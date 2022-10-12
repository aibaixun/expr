package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprParserContext;

/**
 * @author wang xiao
 * date 2022/10/11
 */
public class ElExprParserContext implements ExprParserContext {
    @Override
    public boolean isTemplate() {
        return false;
    }

    @Override
    public String getExpressionPrefix() {
        return null;
    }

    @Override
    public String getExpressionSuffix() {
        return null;
    }
}
