package com.aibaixun.expression;

public interface Evaluator {

    /**
     * 计算表达式
     * @param evaExpression 公式表达式
     * @param expressContext 变量值数据获取
     * @return Objet
     */
    Object  execute(String evaExpression,ExpressContext<String,Object> expressContext);
}
