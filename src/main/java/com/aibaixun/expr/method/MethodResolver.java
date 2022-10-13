package com.aibaixun.expr.method;

import com.aibaixun.expr.ExprEvalContext;

import java.util.List;

/**
 * @author wang xiao
 * date 2022/10/10
 */
public interface MethodResolver {

    /**
     * 解析 方法
     * @param context 运行上下文
     * @param targetObject 目标对象
     * @param name 方法名称
     * @param argumentTypes 类型
     * @return 方法执行器材
     */
    MethodExecutor resolve(ExprEvalContext context, Object targetObject, String name, List<Class<?>> argumentTypes);
}
