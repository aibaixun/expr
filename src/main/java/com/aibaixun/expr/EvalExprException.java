package com.aibaixun.expr;

/**
 * 执行表达式异常
 * @author wang xiao
 * date 2022/10/8
 */
public class EvalExprException extends ExprException{
    public EvalExprException(String message) {
        super(message);
    }

    public EvalExprException(String message, Throwable cause) {
        super(message, cause);
    }

    public EvalExprException(String message, String expression) {
        super(message, expression);
    }
}
