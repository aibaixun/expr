package com.aibaixun.expr.el;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.ExprEvalException;
import com.aibaixun.expr.util.ExprUtil;

import java.util.Objects;

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
        return expression;
    }

    @Override
    public Object getValue() throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(getExprEvalContext());
        return this.ast.getValue(expressionState);
    }

    @Override
    public <T> T getValue(Class<T> tClass) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(getExprEvalContext());
        Object value = this.ast.getValue(expressionState);
        return ExprUtil.convertValue(expressionState.getRelatedEvalContext(),value,tClass);
    }

    @Override
    public Object getValue(Object rootObj) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(getExprEvalContext(),rootObj);
        return this.ast.getValue(expressionState);
    }

    @Override
    public <T> T getValue(Object rootObj, Class<T> tClass) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(getExprEvalContext());
        Object value = this.ast.getValue(expressionState);
        return ExprUtil.convertValue(expressionState.getRelatedEvalContext(),value,tClass);
    }

    @Override
    public Object getValue(ExprEvalContext context) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(context);
        return this.ast.getValue(expressionState);
    }

    @Override
    public Object getValue(ExprEvalContext context, Object rootObj) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(context,rootObj);
        return this.ast.getValue(expressionState);
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Class<T> tClass) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(context);
        Object value = this.ast.getValue(expressionState);
        if (Objects.isNull(value)){
            return (T) value;
        }
        return ExprUtil.convertValue(context,value,tClass);
    }

    @Override
    public <T> T getValue(ExprEvalContext context, Object rootObj, Class<T> tClass) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(context,rootObj);
        Object value = this.ast.getValue(expressionState);
        if (Objects.isNull(value)){
            return (T) value;
        }
        return ExprUtil.convertValue(context,value,tClass);
    }

    @Override
    public Class<?> getValueType() throws ExprEvalException {
        return getValueType(getExprEvalContext());
    }

    @Override
    public Class<?> getValueType(ExprEvalContext context) throws ExprEvalException {
        ExpressionState expressionState = new ExpressionState(context);
        return null;
    }

    @Override
    public Class<?> getValueType(Object rootObj) throws ExprEvalException {
        return getValueType(getExprEvalContext(),rootObj);
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

    public void setExprEvalContext(ExprEvalContext exprEvalContext) {
        this.exprEvalContext = exprEvalContext;
    }

    public ExprEvalContext getExprEvalContext() {
        if (Objects.isNull(expression)){
            return new ElExprEvalContext();
        }
        return exprEvalContext;
    }


}
