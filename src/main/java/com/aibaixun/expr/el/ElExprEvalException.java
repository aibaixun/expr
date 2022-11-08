package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprEvalException;

/**
 * @author wang xiao
 * date 2022/11/8
 */
public class ElExprEvalException extends ExprEvalException {

    public ElExprEvalException(String message) {
        super(message);
    }

    public ElExprEvalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElExprEvalException(String message, String expression) {
        super(message, expression);
    }
}
