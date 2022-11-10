package com.aibaixun.expr.el.standard;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;
import com.aibaixun.expr.common.TemplateExprParser;
import com.aibaixun.expr.el.ElExpr;
import com.aibaixun.expr.el.ElExprParserConfig;
import com.aibaixun.expr.el.ElNode;
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


    public InternalElExpressionParser(ElExprParserConfig parserConfig) {
        this.parserConfig = parserConfig;
    }

    @Override
    protected ElExpr doParseExpression(String expression, ExprParserContext context) throws ExprParserException {
        this.expression = expression;
        Tokenizer tokenizer = new Tokenizer(expression);
        return new ElExpr(expression,null);
    }

    public ElExprParserConfig getParserConfig() {
        return parserConfig;
    }
}
