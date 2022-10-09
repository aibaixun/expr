package com.aibaixun.expr.type;

/**
 * @author wang xiao
 * date 2022/10/9
 */
public class TypeValue {

    public static final TypeValue NIL = new TypeValue(null);

    private final Object value;

    public TypeValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
