package com.aibaixun.expr;

/**
 * 解析表达式 异常
 * @author wang xiao
 * date 2022/10/8
 */
public class ExprParserException extends ExprException{


    public ExprParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExprParserException(String message, String expression) {
        super(message, expression);
    }

    public ExprParserException(String message, String expression, int position) {
        super(message, expression, position);
    }

    public ExprParserException(String message, Throwable cause, String expression, int position) {
        super(message, cause, expression, position);
    }

}
