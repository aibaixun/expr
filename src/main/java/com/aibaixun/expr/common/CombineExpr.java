package com.aibaixun.expr.common;

import com.aibaixun.expr.EvalExprContext;
import com.aibaixun.expr.EvalExprException;
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
    public String getValue() throws EvalExprException {
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
    public <T> T getValue(Class<T> tClass) throws EvalExprException {
        Object value  = getValue() ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public Object getValue(Object rootObj) throws EvalExprException {
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
    public <T> T getValue(Object rootObj, Class<T> tClass) throws EvalExprException {
        Object value  = getValue(rootObj) ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public Object getValue(EvalExprContext context) throws EvalExprException {
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
    public Object getValue(EvalExprContext context, Object rootObj) throws EvalExprException {
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
    public <T> T getValue(EvalExprContext context, Class<T> tClass) throws EvalExprException {
        Object value  = getValue(context) ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
    }

    @Override
    public <T> T getValue(EvalExprContext context, Object rootObj, Class<T> tClass) throws EvalExprException {
        Object value  = getValue(context,rootObj) ;
        return ExprUtil.convertValue(null,new TypeValue(value),tClass);
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
        throw new EvalExprException(this.expression,"Can`t writeValue on CombineExpr");
    }

    @Override
    public void writeValue(Object rootObj, Object value) {
        throw new EvalExprException(this.expression,"Can`t writeValue on CombineExpr");
    }

    @Override
    public void writeValue(EvalExprContext context, Object rootObj, Object value) {
        throw new EvalExprException(this.expression,"Can`t writeValue on CombineExpr");
    }
}
