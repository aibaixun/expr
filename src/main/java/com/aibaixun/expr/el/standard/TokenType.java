package com.aibaixun.expr.el.standard;

/**
 * @author wang xiao
 * date 2022/10/17
 */
public enum TokenType {

    INT,

    LONG,

    STRING,
    /**
     * +
     */
    PLUS("+");
    private  String token;

    TokenType(String token) {
        this.token = token;
    }

    TokenType() {
    }

    public String getToken() {
        return token;
    }
}
