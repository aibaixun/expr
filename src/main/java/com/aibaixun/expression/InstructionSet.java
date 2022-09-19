package com.aibaixun.expresstion;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 指令集合
 */
public class InstructionSet {

    private final String type;

    private String name;


    private final List<InstructionSet> childInstructionSet = new ArrayList<>();


    public InstructionSet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public ExpressCallResult execute( boolean isTrace,ExpressContext<String,Object> context) throws Exception {

        if (childInstructionSet.isEmpty()){
            return ExpressCallResult.empty();
        }
        for (InstructionSet instructionSet : childInstructionSet) {
            instructionSet.execute(isTrace,context);
        }
        return null;
    }

    public void addInstructionSet (InstructionSet instructionSet) {
        this.childInstructionSet.add(instructionSet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InstructionSet> getChildInstructionSet() {
        return childInstructionSet;
    }
}
