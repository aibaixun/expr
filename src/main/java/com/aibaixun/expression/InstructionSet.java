package com.aibaixun.expresstion;



/**
 * 指令集合
 */
public class InstructionSet {

    private final String type;

    private String name;


    public InstructionSet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public ExpressCallResult execute( boolean isTrace,ExpressContext<String,Object> context) throws Exception {
        return null;
    }
}
