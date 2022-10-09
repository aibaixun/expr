package com.aibaixun.expr.common;

import com.aibaixun.expr.EvalExprContext;
import com.aibaixun.expr.EvalExprException;
import com.aibaixun.expr.Expr;

/**
 * 确切的表达式
 * @author wang xiao
 * date 2022/10/8
 */
public class LiteralExpr implements Expr {

    private final String literal;

    public LiteralExpr(String literal) {
        this.literal = literal;
    }

    @Override
    public String getExpression() {
        return literal;
    }

    @Override
    public String getValue() throws EvalExprException {
        return literal;
    }

    @Override
    public <T> T getValue(Class<T> tClass) throws EvalExprException {
        return null;
    }

    @Override
    public Object getValue(Object rootObj) throws EvalExprException {
        return null;
    }

    @Override
    public <T> T getValue(Object rootObj, Class<T> tClass) throws EvalExprException {
        return null;
    }

    @Override
    public Object getValue(EvalExprContext context) throws EvalExprException {
        return null;
    }

    @Override
    public Object getValue(EvalExprContext context, Object rootObj) throws EvalExprException {
        return null;
    }

    @Override
    public <T> T getValue(EvalExprContext context, Class<T> tClass) throws EvalExprException {
        return null;
    }

    @Override
    public <T> T getValue(EvalExprContext context, Object rootObj, Class<T> tClass) throws EvalExprException {
        return null;
    }

    @Override
    public Class<?> getValueType() throws EvalExprException {
        return String.class;
    }

    @Override
    public Class<?> getValueType(EvalExprContext context) throws EvalExprException {
        return String.class;
    }

    @Override
    public Class<?> getValueType(Object rootObj) throws EvalExprException {
        return String.class;
    }

    @Override
    public Class<?> getValueType(EvalExprContext context, Object rootObj) throws EvalExprException {
        return String.class;
    }

    @Override
    public boolean isWriteable(EvalExprContext context) throws EvalExprException {
        return false;
    }

    @Override
    public boolean isWriteable(EvalExprContext context, Object rootObj) throws EvalExprException {
        return false;
    }

    @Override
    public void writeValue(EvalExprContext context, Object value) {
        throw new EvalExprException(this.literal,"Can`t writeValue on LiteralExpr");
    }

    @Override
    public void writeValue(Object rootObj, Object value) {
        throw new EvalExprException(this.literal,"Can`t writeValue on LiteralExpr");
    }

    @Override
    public void writeValue(EvalExprContext context, Object rootObj, Object value) {
        throw new EvalExprException(this.literal,"Can`t writeValue on LiteralExpr");
    }
}
