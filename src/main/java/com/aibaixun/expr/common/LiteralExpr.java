package com.aibaixun.expr.common;

import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.ExprEvalException;
import com.aibaixun.expr.Expr;
import com.aibaixun.expr.type.TypeValue;
import com.aibaixun.expr.util.ExprUtil;

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
    public String getValue() throws ExprEvalException {
        return literal;
    }

    @Override
    public <T> T getValue(Class<T> tClass) throws ExprEvalException {
        String value = getValue();
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public String getValue(Object rootObj) throws ExprEvalException {
        return literal;
    }

    @Override
    public <T> T getValue(Object rootObj, Class<T> tClass) throws ExprEvalException {
        Object value =  getValue(rootObj);
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public Object getValue(ExprEvalContext context) throws ExprEvalException {
        return literal;
    }

    @Override
    public Object getValue(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        return literal;
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Class<T> tClass) throws ExprEvalException {
       Object value = getValue(context);
       return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Object rootObj, Class<T> tClass) throws ExprEvalException {
        Object value = getValue(context,rootObj);
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public Class<?> getValueType() throws ExprEvalException {
        return String.class;
    }

    @Override
    public Class<?> getValueType(ExprEvalContext context) throws ExprEvalException {
        return String.class;
    }

    @Override
    public Class<?> getValueType(Object rootObj) throws ExprEvalException {
        return String.class;
    }

    @Override
    public Class<?> getValueType(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        return String.class;
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
        throw new ExprEvalException(this.literal,"Can`t writeValue on LiteralExpr");
    }

    @Override
    public void writeValue(Object rootObj, Object value) {
        throw new ExprEvalException(this.literal,"Can`t writeValue on LiteralExpr");
    }

    @Override
    public void writeValue(ExprEvalContext context, Object rootObj, Object value) {
        throw new ExprEvalException(this.literal,"Can`t writeValue on LiteralExpr");
    }
}
