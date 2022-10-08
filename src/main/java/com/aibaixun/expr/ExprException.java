package com.aibaixun.expr;

/**
 * @author wang xiao
 * date 2022/10/8
 */
public class ExprException extends RuntimeException{

    /**
     * String expression
     */
    private  final String expression;

    public ExprException(String message) {
        super(message);
        this.expression = null;
    }

    public ExprException(String message, Throwable cause) {
        super(message, cause);
        this.expression = null;
    }

    public ExprException(String message, String expression) {
        super(message);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String getMessage() {
        return this.buildExceptionMessage();
    }

    private String buildExceptionMessage() {
        if (expression != null) {
            return "Expression :" + expression +
                    ",error: " + super.getMessage();
        }else {
            return super.getMessage();
        }
    }
}
