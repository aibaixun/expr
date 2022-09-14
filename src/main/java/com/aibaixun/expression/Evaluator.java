package com.aibaixun.expression;

public interface Evaluator {

    /**
     * 计算表达式
     * @param evaExpression 公式表达式
     * @param expressContext 变量值数据获取
     * @param isCache 是否缓存
     * @param isTrace 输出详细信息
     * @return Objet
     */
    Object  execute(String evaExpression,ExpressContext<String,Object> expressContext, boolean isCache, boolean isTrace)throws Exception;
}
