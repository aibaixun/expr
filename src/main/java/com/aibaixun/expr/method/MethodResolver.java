package com.aibaixun.expr.method;

import com.aibaixun.expr.ExprEvalContext;
import com.aibaixun.expr.el.ElExprEvalContext;

import java.util.List;

/**
 * @author wang xiao
 * date 2022/10/10
 */
public interface MethodResolver {


    MethodExecutor resolve(ExprEvalContext context, Object targetObject, String name, List<Class<?>> argumentTypes);
}
