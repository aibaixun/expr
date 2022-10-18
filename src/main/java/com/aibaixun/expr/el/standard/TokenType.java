package com.aibaixun.expr.el.standard;

/**
 * @author wang xiao
 * date 2022/10/17
 */
public enum TokenType {
    /**
     * +
     */
    PLUS("+");
    private final String token;

    TokenType(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
