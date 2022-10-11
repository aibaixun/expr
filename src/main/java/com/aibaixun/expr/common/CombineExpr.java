package com.aibaixun.expr.common;

import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.ExprEvalException;
import com.aibaixun.expr.Expr;
import com.aibaixun.expr.type.TypeValue;
import com.aibaixun.expr.util.ExprUtil;

import java.util.Objects;

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
    public String getValue() throws ExprEvalException {
        StringBuilder sb = new StringBuilder();
        for (Expr expr : exprArray) {
            String value = expr.getValue(String.class);
            if (Objects.nonNull(value)){
                sb.append(value);
            }
        }
        return sb.toString();
    }

    @Override
    public <T> T getValue(Class<T> tClass) throws ExprEvalException {
        Object value  = getValue() ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public Object getValue(Object rootObj) throws ExprEvalException {
        StringBuilder sb = new StringBuilder();
        for (Expr expr : exprArray) {
            String value = expr.getValue(rootObj,String.class);
            if (Objects.nonNull(value)){
                sb.append(value);
            }
        }
        return sb.toString();
    }

    @Override
    public <T> T getValue(Object rootObj, Class<T> tClass) throws ExprEvalException {
        Object value  = getValue(rootObj) ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public Object getValue(ExprEvalContext context) throws ExprEvalException {
        StringBuilder sb = new StringBuilder();
        for (Expr expr : exprArray) {
            String value = expr.getValue(context,String.class);
            if (Objects.nonNull(value)){
                sb.append(value);
            }
        }
        return sb.toString();
    }

    @Override
    public Object getValue(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        StringBuilder sb = new StringBuilder();
        for (Expr expr : exprArray) {
            String value = expr.getValue(context,rootObj,String.class);
            if (Objects.nonNull(value)){
                sb.append(value);
            }
        }
        return sb.toString();
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Class<T> tClass) throws ExprEvalException {
        Object value  = getValue(context) ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Object rootObj, Class<T> tClass) throws ExprEvalException {
        Object value  = getValue(context,rootObj) ;
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
        throw new ExprEvalException(this.expression,"Can`t writeValue on CombineExpr");
    }

    @Override
    public void writeValue(Object rootObj, Object value) {
        throw new ExprEvalException(this.expression,"Can`t writeValue on CombineExpr");
    }

    @Override
    public void writeValue(ExprEvalContext context, Object rootObj, Object value) {
        throw new ExprEvalException(this.expression,"Can`t writeValue on CombineExpr");
    }
}
