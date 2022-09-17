package com.aibaixun.expresstion;


import com.aibaixun.expresstion.exception.ExpressException;
import com.aibaixun.expresstion.node.ExpressNode;


public class ExpressionEvaluator implements Evaluator{


    private final ExpressInstructionSetCache expressInstructionSetCache;

    private final ExpressionParse expressionParse;


    public ExpressionEvaluator(ExpressInstructionSetCache expressInstructionSetCache, ExpressionParse expressionParse) {
        this.expressInstructionSetCache = expressInstructionSetCache;
        this.expressionParse = expressionParse;
    }

    @Override
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
    private Object execute(InstructionSet parseResult, ExpressContext<String, Object> expressContext,  boolean isTrace)throws Exception {
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
            return createInstructionSet(root, "main");
        } catch (ExpressException e) {
            throw e;
        } catch (Exception e) {
            throw new ExpressException("编译异常:\n" + expression, e);
        }
    }

    public InstructionSet createInstructionSet(ExpressNode root, String type) throws Exception {
        InstructionSet result = new InstructionSet(type);
        createInstructionSet(root, result);
        return result;
    }

    public void createInstructionSet(ExpressNode root, InstructionSet result) throws Exception {

    }
}
