package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprParserException;

/**
 * @author wang xiao
 * date 2022/10/17
 */
public class ElExprParserException extends ExprParserException {

    public ElExprParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElExprParserException(String message, String expression) {
        super(message, expression);
    }

    public ElExprParserException(String message, String expression, int position) {
        super(message, expression, position);
    }

    public ElExprParserException(String message, Throwable cause, String expression, int position) {
        super(message, cause, expression, position);
    }
}
