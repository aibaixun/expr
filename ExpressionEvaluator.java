package com.aibaixun.expression;

public class ExpressionEvaluator implements Evaluator{

    @Override
    public Object execute(String evaExpression, ExpressContext<String, Object> expressContext, boolean isCache, boolean isTrace)throws Exception {
        if (isCache){
            
        }
        return executeReentrant(evaExpression,expressContext,isCache,isTrace);
    }


    /**
     *
     * @param evaExpression
     * @param expressContext
     * @param isCache
     * @param isTrace
     * @return
     * @throws Exception
     */
    private Object executeReentrant(String evaExpression, ExpressContext<String, Object> expressContext, boolean isCache, boolean isTrace)throws Exception {
        return null;
    }
}
