package com.aibaixun.expression;

public enum StaticOP implements OP{

    /**
     *  equals
     */
    EQ("="),

    /**
     *  not equals
     */
    NE("<>"),

    /**
     *  like
     */
    LIKE("LIKE"),

    /**
     * not like
     */
    NOT_LIKE("NOT LIKE"),

    /**
     * like left
     */
    LEFT_LIKE("LIKE"),

    /**
     * like right
     */
    RIGHT_LIKE("LIKE"),

    /**
     * >
     */
    GT(">"),

    /**
     * >=
     */
    GE(">="),

    /**
     * <
     */
    LT("<"),

    /**
     * <=
     */
    LE("<="),

    /**
     * is null
     */
    IS_NULL("IS NULL"),

    /**
     * is not null
     */
    IS_NOT_NULL("IS NOT NULL"),

    /**
     * asc
     */
    ASC("ASC"),

    /**
     * desc
     */
    DESC("DESC");


    private final String expression;


     StaticOP(final String expression) {
        this.expression = expression;
    }

    @Override
    public String getOpExpression() {
        return expression;
    }
}
