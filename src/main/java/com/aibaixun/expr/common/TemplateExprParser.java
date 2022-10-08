package com.aibaixun.expr.common;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprParser;
import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;

/**
 * 模版解析
 *
 * @author wang xiao
 * date 2022/10/8
 */
public class TemplateExprParser implements ExprParser {

    @Override
    public Expr parseExpression(String expression) throws ExprParserException {
        return parseExpression(expression, null);
    }

    @Override
    public Expr parseExpression(String expression, ExprParserContext context) throws ExprParserException {
        if (context != null && context.isTemplate()) {
            return doParseTemplate(expression, context);
        } else {
            return doParseExpression(expression, context);
        }
    }

    /**
     * 解析模版
     *
     * @param expression 表达式内容
     * @param context    模版上下文
     * @return Expr
     * @throws ExprParserException exception
     */
    private Expr doParseTemplate(String expression, ExprParserContext context) throws ExprParserException {
        if (expression.isEmpty()) {

        }
        return null;
    }

    /**
     * 解析 expression
     *
     * @param expression 表达式内容
     * @param context    解析上下文
     * @return Expr
     * @throws ExprParserException exception
     */
    private Expr doParseExpression(String expression, ExprParserContext context) throws ExprParserException {
        return null;
    }
}
