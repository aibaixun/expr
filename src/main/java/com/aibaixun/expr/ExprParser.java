package com.aibaixun.expr;

/**
 * exprParser 表达式解析类
 * @author wang xiao
 * date 2022/10/8
 */
public interface ExprParser {

    /**
     * 解析表达式
     * 使用默认的解析上下文
     * @param expression 表达式内容
     * @return  Expr 实例
     * @throws ExprParserException  exception
     */
    Expr parseExpression(String expression) throws ExprParserException;


    /**
     * 解析表达式
     * @param expression 表达式内容
     * @param context 解析上下文
     * @return  Expr 实例
     * @throws ExprParserException  exception
     */
    Expr parseExpression(String expression,ExprParserContext context) throws ExprParserException;
}
