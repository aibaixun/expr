package com.aibaixun.expr.el;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;
import com.aibaixun.expr.common.TemplateExprParser;

/**
 * @author wang xiao
 * date 2022/10/11
 */
public class ElExprParser extends TemplateExprParser {

    private final ElExprParserConfig  parserConfig;

    public ElExprParser() {
        this.parserConfig = new ElExprParserConfig();
    }

    public ElExpr parseRaw(String expressionString) throws ExprParserException {
        return this.doParseExpression(expressionString, null);
    }
    @Override
    protected ElExpr doParseExpression(String expression, ExprParserContext context) throws ExprParserException {
        return null;
    }

    public ElExprParserConfig getParserConfig() {
        return parserConfig;
    }
}
