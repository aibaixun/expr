package com.aibaixun.expr.common;

import com.aibaixun.expr.ExprParserContext;

/**
 * 模版表达式解析上下文
 *
 * @author wang xiao
 * date 2022/10/8
 */
public class TemplateExprParserContext implements ExprParserContext {

    private final String prefix;

    private final String suffix;

    public TemplateExprParserContext(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public boolean isTemplate() {
        return true;
    }

    @Override
    public String getExpressionPrefix() {
        return prefix;
    }

    @Override
    public String getExpressionSuffix() {
        return suffix;
    }
}
