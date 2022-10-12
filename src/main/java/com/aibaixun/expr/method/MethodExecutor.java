package com.aibaixun.expr.method;

import com.aibaixun.expr.el.ElExprEvalContext;

/**
 * @author wang xiao
 * date 2022/10/10
 */
public interface MethodExecutor {

    Object execute(ElExprEvalContext context, Object target, Object ...args);
}
