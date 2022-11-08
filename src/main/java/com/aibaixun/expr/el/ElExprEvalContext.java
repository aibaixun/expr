package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.TypeConverter;
import com.aibaixun.expr.common.StandardTypeConverter;

/**
 * @author wang xiao
 * date 2022/10/11
 */
public class ElExprEvalContext implements ExprEvalContext {

    private Object rotObject;

    private final TypeConverter typeConverter;

    public ElExprEvalContext() {
        this.typeConverter = new StandardTypeConverter();
    }

    @Override
    public TypeConverter getTypeConverter() {
        return typeConverter;
    }


    @Override
    public Object getRootObject() {
        return rotObject;
    }
}
