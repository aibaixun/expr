package com.aibaixun.expr;

/**
 * 表达式 异常类
 * 该项目全局异常
 * @author wang xiao
 * date 2022/10/8
 */
public class ExprException extends RuntimeException{

    /**
     * 异常表达式
     */
    private  final String expression;

    /**
     * 异常位置下标
     */
    protected final int position;

    public ExprException(String message) {
        super(message);
        this.expression = null;
        this.position = -1;
    }

    public ExprException(String message, Throwable cause) {
        super(message, cause);
        this.expression = null;
        this.position = -1;
    }

    public ExprException(String message, String expression) {
        super(message);
        this.expression = expression;
        this.position = -1;
    }

    public ExprException(String message, String expression, int position) {
        super(message);
        this.expression = expression;
        this.position = position;
    }

    public ExprException(String message, Throwable cause, String expression, int position) {
        super(message, cause);
        this.expression = expression;
        this.position = position;
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
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Expression [").append(expression).append("]");
          if (this.position != -1) {
              stringBuilder.append(", position: ").append(this.position);
          }
          stringBuilder.append("cause by ").append(super.getMessage());
          return stringBuilder.toString();
        }else {
            return super.getMessage();
        }
    }
}
