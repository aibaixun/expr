package com.aibaixun.expr;

/**
 * 表达式解析上下文
 *
 * @author wang xiao
 * date 2022/10/8
 */
public interface ExprParserContext {

    /**
     * 是否为模版
     *
     * @return boolean
     */
    boolean isTemplate();


    /**
     * 模版表达式的开始
     *
     * @return String
     */
    String getExpressionPrefix();


    /**
     * 模版表达式的结束
     *
     * @return String
     */
    String getExpressionSuffix();
}
