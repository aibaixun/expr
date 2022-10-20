package com.aibaixun.expr.el.standard;

/**
 * @author wang xiao
 * date 2022/10/17
 */
public enum TokenType {
    /**
     *
     */
    INT,
    LONG,
    STRING,
    REAL,
    REAL_FLOAT,
    LPAREN("("),
    RPAREN(")"),
    COMMA(","),
    IDENTIFIER,
    COLON(":"),
    HASH("#"),
    RSQUARE("]"),
    LSQUARE("["),
    LCURLY("{"),
    RCURLY("}"),
    DOT("."),
    PLUS("+"),
    STAR("*"),
    MINUS("-"),
    SELECT_FIRST("^["),
    SELECT_LAST("$["),
    QMARK("?"),
    PROJECT("!["),
    DIV("/"),
    GE(">="),
    GT(">"),
    LE("<="),
    LT("<"),
    EQ("=="),
    NE("!="),
    MOD("%"),
    NOT("!"),
    ASSIGN("="),
    POWER("^"),
    ELVIS("?:"),
    FACTORY_BEAN_REF("&"),
    SYMBOLIC_OR("||"),
    SYMBOLIC_AND("&&"),
    INC("++"),
    DEC("--");

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
