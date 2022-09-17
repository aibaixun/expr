package com.aibaixun.expresstion;



public class InstructionSetRunner {

    private InstructionSetRunner() {
    }


    public static Object execute(InstructionSet set, ExpressContext<String,Object> context,boolean isTrace ) throws Exception {
        Object result = null;
        ExpressCallResult tempResult = set.execute(isTrace, context);
        if (tempResult.isExit()) {
            result = tempResult.getReturnValue();
        }
        return result;
    }
}
