package com.aibaixun.expr.common;

import com.aibaixun.expr.Expr;
import com.aibaixun.expr.ExprParser;
import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 模版解析
 *
 * @author wang xiao
 * date 2022/10/8
 */
public abstract class TemplateExprParser implements ExprParser {

    @Override
    public Expr parseExpression(String expression) throws ExprParserException {
        return parseExpression(expression, null);
    }

    @Override
    public Expr parseExpression(String expression, ExprParserContext context) throws ExprParserException {
        if (context != null && context.isTemplate()) {
            return parseTemplate(expression, context);
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
    private Expr parseTemplate(String expression, ExprParserContext context) throws ExprParserException {
        if (expression.isEmpty()) {
            return new LiteralExpr("");
        }
        Expr [] exprArray =  parseExpressions(expression, context);
        if (exprArray.length == 1) {
            return exprArray[0];
        }else {
            return new CombineExpr(expression,exprArray);
        }
    }

    /**
     * 解析 表达式
     *
     * @param expression 表达式内容
     * @param context    解析上下文
     * @return Expr
     * @throws ExprParserException exception
     */
    protected abstract Expr doParseExpression(String expression, ExprParserContext context) throws ExprParserException;


    /**
     * 解析表达式
     * @param expression 表达式内容
     * @param context    解析上下文
     * @return  Expr 数组
     * @throws ExprParserException exception
     */
    private Expr [] parseExpressions(String expression, ExprParserContext context) throws ExprParserException {
        List<Expr> exprList = new ArrayList<>();
        String prefix = context.getExpressionPrefix();
        String suffix = context.getExpressionSuffix();
        int startInx = 0;

        while (startInx < expression.length()) {
            int prefixInx = expression.indexOf(prefix,startInx);
            if (prefixInx >= startInx){
                if(prefixInx > startInx){
                    exprList.add(new LiteralExpr(expression.substring(startInx, prefixInx)));
                }
                int afterPrefixInx =  prefixInx + prefix.length();
                int suffixInx = findSuffix(suffix,expression,afterPrefixInx);
                if (suffixInx == -1){
                    throw new ExprParserException(expression,"Cannot found suffix at pos "+ afterPrefixInx);
                }
                if (suffixInx ==  afterPrefixInx){
                    throw new ExprParserException(expression,"No find suffix found for expression starting at"+ afterPrefixInx);
                }
                String  expr = expression.substring(afterPrefixInx, suffixInx);
                expr = expr.trim();
                if (expr.isEmpty()) {
                    throw new ExprParserException(expression,"No expression defined within delimiter "+ prefix + suffix+ " at character"+ prefixInx);
                }
                exprList.add(doParseExpression(expr,context));
                startInx = suffixInx+ suffix.length();
            }else {
                // 没有匹配到开始 prefix
                exprList.add(new LiteralExpr(expression.substring(startInx)));
                startInx = expression.length();
            }
        }
        return exprList.toArray(new Expr[0]);
    }

    /**
     * 查找到结束位置
     * @param suffix 结束符号
     * @param expression 表达式内容
     * @param afterPrefixInx 查找位置开始
     * @return 下标
     */
    private int findSuffix(String suffix,String expression,int afterPrefixInx) throws ExprParserException{
        int pos  = afterPrefixInx;
        int maxLen = expression.length();
        int nextSuffix = expression.indexOf(suffix,afterPrefixInx);
        if (nextSuffix == -1){
            return -1;
        }
        Deque<CharBracket> stack = new ArrayDeque<>();
        while (pos < maxLen) {
            if (isSuffixHere(expression,pos,suffix) && stack.isEmpty()) {
                break;
            }
            char c = expression.charAt(pos);
            switch (c){
                case '{':
                case '(':
                case '[':
                    stack.push(new CharBracket(c,pos));
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.isEmpty()){
                        throw new ExprParserException(expression,"Found Close at "+pos+" without an opening "+ CharBracket.theOpenBracketFor(c),pos);
                    }
                    CharBracket pop = stack.pop();
                    if (!pop.compatibleWithCloseBracket(c)){
                        throw new ExprParserException(expression,"Found Close at "+pos+" without an opening ",pos);
                    }
                    break;
                case '\'':
                case '\"':
                    int endLiteral = expression.indexOf(c,pos+1);
                    if (endLiteral == -1){
                        throw new ExprParserException(expression,"Found non terminating string literal Staring  at "+pos,pos);
                    }
                    pos = endLiteral;
                    break;
                default:
                    break;
            }
            pos++;
        }
        if (!stack.isEmpty()){
            throw new ExprParserException(expression,"Missing closing bracket at position "+pos);
        }
        if (!isSuffixHere(expression,pos,suffix)){
            return -1;
        }
        return pos;
    }

    private boolean isSuffixHere(String expression,int pos,String suffix){
        int suffixPosition = 0;
        for (int i = 0; i < suffix.length()&& pos < expression.length(); i++){
            if (expression.charAt(pos++) !=  suffix.charAt(suffixPosition)){
                return false;
            }
        }
        return suffixPosition == suffix.length();
    }

}
