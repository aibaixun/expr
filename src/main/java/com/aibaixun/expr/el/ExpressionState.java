package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprEvalContext;

/**
 * @author wang xiao
 * date 2022/11/8
 */
public class ExpressionState {

    private final ExprEvalContext relatedEvalContext;

    private final Object rootObject;


    public ExpressionState(ExprEvalContext relatedEvalContext) {
        this(relatedEvalContext,relatedEvalContext.getRootObject());
    }

    public ExprEvalContext getRelatedEvalContext() {
        return relatedEvalContext;
    }

    public ExpressionState(ExprEvalContext relatedEvalContext, Object rootObject) {
        this.relatedEvalContext = relatedEvalContext;
        this.rootObject = rootObject;
    }

    public Object getRootObject() {
        return rootObject;
    }
}
