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

        return new ElExpr(expression,null);
    }

    public ElExprParserConfig getParserConfig() {
        return parserConfig;
    }


}
