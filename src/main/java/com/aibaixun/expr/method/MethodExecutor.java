package com.aibaixun.expr.method;

import com.aibaixun.expr.el.ElExprEvalContext;

/**
 * 方法执行
 * @author wang xiao
 * date 2022/10/10
 */
public interface MethodExecutor {

    /**
     * 执行方法
     * @param context 执行上下文
     * @param target target
     * @param args 参数
     * @return 执行结果
     */
    Object execute(ElExprEvalContext context, Object target, Object ...args);
}
