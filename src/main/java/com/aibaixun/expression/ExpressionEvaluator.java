package com.aibaixun.expresstion;


import com.aibaixun.expresstion.exception.ExpressException;
import com.aibaixun.expresstion.node.ExpressNode;

import java.util.List;


public class ExpressionEvaluator {


    private final ExpressInstructionSetCache expressInstructionSetCache;

    private final ExpressionParse expressionParse;


    public ExpressionEvaluator(ExpressInstructionSetCache expressInstructionSetCache, ExpressionParse expressionParse) {
        this.expressInstructionSetCache = expressInstructionSetCache;
        this.expressionParse = expressionParse;
    }


    public Object execute(String evaExpression, ExpressContext<String, Object> expressContext, boolean isCache, boolean isTrace)throws Exception {
        InstructionSet parseResult ;
        if (isCache){
            parseResult = expressInstructionSetCache.getInstructionSet(evaExpression);
            if (parseResult == null) {
                synchronized (expressInstructionSetCache) {
                    parseResult = expressInstructionSetCache.getInstructionSet(evaExpression);
                    if (parseResult == null) {
                        parseResult = parseInstructionSet(evaExpression);
                        expressInstructionSetCache.addInstruction(evaExpression, parseResult);
                    }
                }
            }
        }else {
            parseResult = parseInstructionSet(evaExpression);

        }
        return execute(parseResult,expressContext,isTrace);
    }


    /**
     * 执行命令
     * @param parseResult 解析后的指令集合
     * @param expressContext 解析 上下文
     * @param isTrace isTrace
     * @return Object
     * @throws Exception  异常信息
     */
    public Object execute(InstructionSet parseResult, ExpressContext<String, Object> expressContext,  boolean isTrace)throws Exception {
       return InstructionSetRunner.execute(parseResult,expressContext,isTrace);
    }


    /**
     * 解析 表达式
     * @param expression 表达式
     * @return 指令集合
     */
    private InstructionSet parseInstructionSet(String expression){
        try {
            ExpressNode root = expressionParse.parse( expression);
            return createInstructionSet(root);
        } catch (Exception e) {
            throw new ExpressException("编译异常:\n" + expression, e);
        }
    }

    public InstructionSet createInstructionSet(ExpressNode root) {
        InstructionSet result = new InstructionSet(root.getName());
        List<ExpressNode> children = root.getChildren();
        for (ExpressNode tempNode : children){
            result.addInstructionSet(createInstructionSet(tempNode));
        }
        return result;
    }


}
