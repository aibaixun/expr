package com.aibaixun.expr;

/**
 * exprParser 表达式解析类
 * @author wang xiao
 * date 2022/10/8
 */
public interface ExprParser {

    /**
     * Parses the string expression
     * @param expression string expression
     * @return  instanceof Expr
     */
    Expr parseExpression(String expression);
}
