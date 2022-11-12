package com.aibaixun.expr.el.standard;

import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;
import com.aibaixun.expr.common.TemplateExprParser;
import com.aibaixun.expr.el.ElExpr;
import com.aibaixun.expr.el.ElExprParserConfig;
import com.aibaixun.expr.el.ast.ElNodeImpl;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author wang xiao
 * date 2022/10/20
 */
public class InternalElExpressionParser extends TemplateExprParser {

     private final ElExprParserConfig  parserConfig;

     private final Deque<ElNodeImpl> constructedElNodes = new ArrayDeque<>();

     private List<Token> tokenList = Collections.emptyList();

     private String expression = "";

    private int tokenListLength;
    private int tokenListPointer;


    public InternalElExpressionParser(ElExprParserConfig parserConfig) {
        this.parserConfig = parserConfig;
    }

    @Override
    protected ElExpr doParseExpression(String expression, ExprParserContext context) throws ExprParserException {
        this.expression = expression;
        Tokenizer tokenizer = new Tokenizer(expression);
        this.tokenList = tokenizer.process();
        this.tokenListLength = this.tokenList.size();
        this.tokenListPointer = 0;
        this.constructedElNodes.clear();
        ElNodeImpl ast = eatExpression();
        return new ElExpr(expression,ast);
    }

    private ElNodeImpl eatExpression() {
        ElNodeImpl expr = eatLogicalOrExpression();
        Token t = peekToken();
        if (t != null) {
            if (t.kind == TokenKind.ASSIGN) {  // a=b
                if (expr == null) {
                    expr = new NullLiteral(t.startPos - 1, t.endPos - 1);
                }
                nextToken();
                ElNodeImpl assignedValue = eatLogicalOrExpression();
                return new Assign(t.startPos, t.endPos, expr, assignedValue);
            }
            if (t.kind == TokenKind.ELVIS) {  // a?:b (a if it isn't null, otherwise b)
                if (expr == null) {
                    expr = new NullLiteral(t.startPos - 1, t.endPos - 2);
                }
                nextToken();  // elvis has left the building
                ElNodeImpl valueIfNull = eatExpression();
                if (valueIfNull == null) {
                    valueIfNull = new NullLiteral(t.startPos + 1, t.endPos + 1);
                }
                return new Elvis(t.startPos, t.endPos, expr, valueIfNull);
            }
            if (t.kind == TokenKind.QMARK) {  // a?b:c
                if (expr == null) {
                    expr = new NullLiteral(t.startPos - 1, t.endPos - 1);
                }
                nextToken();
                ElNodeImpl ifTrueExprValue = eatExpression();
                eatToken(TokenKind.COLON);
                ElNodeImpl ifFalseExprValue = eatExpression();
                return new Ternary(t.startPos, t.endPos, expr, ifTrueExprValue, ifFalseExprValue);
            }
        }
        return expr;
    }


    public ElExprParserConfig getParserConfig() {
        return parserConfig;
    }


}
