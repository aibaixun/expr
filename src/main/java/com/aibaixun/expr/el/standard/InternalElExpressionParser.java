package com.aibaixun.expr.el.standard;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;
import com.aibaixun.expr.common.TemplateExprParser;
import com.aibaixun.expr.el.ElExpr;
import com.aibaixun.expr.el.ElExprParserConfig;

/**
 * @author wang xiao
 * date 2022/10/20
 */
 public class InternalElExpressionParser extends TemplateExprParser {

     private final ElExprParserConfig  parserConfig;

    public InternalElExpressionParser(ElExprParserConfig parserConfig) {
        this.parserConfig = parserConfig;
    }

    @Override
    protected ElExpr doParseExpression(String expression, ExprParserContext context) throws ExprParserException {
        return null;
    }

    public ElExprParserConfig getParserConfig() {
        return parserConfig;
    }
}
