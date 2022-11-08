package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprEvalException;

/**
 * @author wang xiao
 * date 2022/10/17
 */
public interface ElNode {

    /**
     * 获取 值
     * @param expressionState the expression state included the context
     * @return 值
     * @throws ExprEvalException
     */
    Object getValue(ExpressionState expressionState) throws ExprEvalException;
}
