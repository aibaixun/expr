package com.aibaixun.expression;

public interface ExpressInstructionSetCache {

    /**
     * 获取 指令集合
     * @param expression expression
     * @return InstructionSet
     */
    InstructionSet   getInstructionSet (String expression);


    /**
     *  添加指令集合
     * @param expression expression
     * @param instructionSet InstructionSet
     */
    void  addInstruction(String expression,InstructionSet instructionSet);
}
