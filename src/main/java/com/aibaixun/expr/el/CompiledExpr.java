package com.aibaixun.expr.el;

import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.ExprEvalException;

/**
 * @author wang xiao
 * date 2022/11/8
 */
public abstract class CompiledExpr {


    public abstract Object getValue(Object target, ExprEvalContext context) throws ExprEvalException;
}
