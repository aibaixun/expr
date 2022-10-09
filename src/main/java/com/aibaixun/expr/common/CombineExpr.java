package com.aibaixun.expr.common;

import com.aibaixun.expr.EvalExprContext;
import com.aibaixun.expr.EvalExprException;
import com.aibaixun.expr.Expr;

/**
 * 组合的 expr
 * @author wang xiao
 * date 2022/10/9
 */
public class CombineExpr implements Expr {

    private final String expression;

    private final Expr[] exprArray;

    public CombineExpr(String expression, Expr[] exprArray) {
        this.expression = expression;
        this.exprArray = exprArray;
    }

    @Override
    public String getExpression() {
        return expression;
    }

    @Override
    public Object getValue() throws EvalExprException {
        return null;
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
        return null;
    }

    @Override
    public Class<?> getValueType(EvalExprContext context) throws EvalExprException {
        return null;
    }

    @Override
    public Class<?> getValueType(Object rootObj) throws EvalExprException {
        return null;
    }

    @Override
    public Class<?> getValueType(EvalExprContext context, Object rootObj) throws EvalExprException {
        return null;
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

    }

    @Override
    public void writeValue(Object rootObj, Object value) {

    }

    @Override
    public void writeValue(EvalExprContext context, Object rootObj, Object value) {

    }
}
