package com.aibaixun.expresstion.node;

import java.util.ArrayList;
import java.util.List;

public class ExpressNode implements ExpressDataNode{


    private ExpressNodeType nodeType;

    private final String value;

    private Object objectValue;

    private final List<ExpressDataNode> children = new ArrayList<>();

    public ExpressNode(ExpressNodeType nodeType, String value) {
        this.nodeType = nodeType;
        this.value = value;
    }

    @Override
    public void setNodeType(ExpressNodeType expressNodeType) {
        this.nodeType = expressNodeType;
    }

    @Override
    public ExpressNodeType getNodeType(ExpressNodeType expressNodeType) {
        return nodeType;
    }

    @Override
    public void setChild(ExpressDataNode ref) {
        this.addChild(ref);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public ExpressDataNode createExpressNode(ExpressNodeType expressNodeType, String expression) {
        return new ExpressNode(expressNodeType, value);
    }

    private void addChild(ExpressDataNode child) {
        if (child == null) {
            return;
        }
        this.children.add(child);
    }
}
