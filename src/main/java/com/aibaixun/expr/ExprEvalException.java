package com.aibaixun.expr;

/**
 * 执行表达式异常
 * @author wang xiao
 * date 2022/10/8
 */
public class ExprEvalException extends ExprException{
    public ExprEvalException(String message) {
        super(message);
    }

    public ExprEvalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExprEvalException(String message, String expression) {
        super(message, expression);
    }
}
