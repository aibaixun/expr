package com.aibaixun.expr.el;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.ExprEvalException;

/**
 * @author wang xiao
 * date 2022/10/11
 */
public class ElExpr implements Expr {

    private final String expression;

    private final ElNode ast;

    private ExprEvalContext exprEvalContext;

    public ElExpr(String expression, ElNode ast) {
        this.expression = expression;
        this.ast = ast;
    }

    @Override
    public String getExpression() {
        return null;
    }

    @Override
    public Object getValue() throws ExprEvalException {
        return null;
    }

    @Override
    public <T> T getValue(Class<T> tClass) throws ExprEvalException {
        return null;
    }

    @Override
    public Object getValue(Object rootObj) throws ExprEvalException {
        return null;
    }

    @Override
    public <T> T getValue(Object rootObj, Class<T> tClass) throws ExprEvalException {
        return null;
    }

    @Override
    public Object getValue(ExprEvalContext context) throws ExprEvalException {
        return null;
    }

    @Override
    public Object getValue(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        return null;
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Class<T> tClass) throws ExprEvalException {
        return null;
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Object rootObj, Class<T> tClass) throws ExprEvalException {
        return null;
    }

    @Override
    public Class<?> getValueType() throws ExprEvalException {
        return null;
    }

    @Override
    public Class<?> getValueType(ExprEvalContext context) throws ExprEvalException {
        return null;
    }

    @Override
    public Class<?> getValueType(Object rootObj) throws ExprEvalException {
        return null;
    }

    @Override
    public Class<?> getValueType(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        return null;
    }

    @Override
    public boolean isWriteable(ExprEvalContext context) throws ExprEvalException {
        return false;
    }

    @Override
    public boolean isWriteable(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        return false;
    }

    @Override
    public void writeValue(ExprEvalContext context, Object value) {

    }

    @Override
    public void writeValue(Object rootObj, Object value) {

    }

    @Override
    public void writeValue(ExprEvalContext context, Object rootObj, Object value) {

    }
}
