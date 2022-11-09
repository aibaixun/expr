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
     * @throws ExprEvalException exception
     */
    Object getValue(ExpressionState expressionState) throws ExprEvalException;

    /**
     * 是否可写
     * @param expressionState expression state
     * @return boolean
     * @throws ExprEvalException exception
     */
    boolean isWriteable(ExpressionState expressionState)throws ExprEvalException;

    /**
     * 设置值
     * @param expressionState the expression state
     * @param value value
     * @throws ExprEvalException exception
     */
    void setValue(ExpressionState expressionState, Object value) throws ExprEvalException;

    /**
     * count children
     * @return int
     */
    int getChildrenCount();

    /**
     * get children
     * @param index children array index
     * @return  elNode
     */
    ElNode getChildren(int index);

    /**
     * object class
     * @param obj obj
     * @return Class for the object
     */
    Class<?> getObjectClass(Object obj);

    /**
     * start pos
     * @return int
     */
    int  getStartPos();


    /**
     * end pos
     * @return int
     */
    int getEndPos();
}
