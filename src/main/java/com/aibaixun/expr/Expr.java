package com.aibaixun.expr;

/**
 * Expr 解析后的类
 * 表示解析后的表达式
 * @author wang xiao
 * date 2022/10/8
 */
public interface Expr {

    /**
     * 获取表达式
     * @return string expression
     */
    String getExpression();

    /**
     * 执行表达式 并获取值
     * 使用默认的执行上下文
     * @return object 执行后的结果
     * @throws EvalExprException exception
     */
    Object getValue()throws EvalExprException;
}
