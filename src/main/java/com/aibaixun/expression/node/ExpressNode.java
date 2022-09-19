package com.aibaixun.expresstion.node;

import java.util.ArrayList;
import java.util.List;

public class ExpressNode {

    private ExpressNodeType nodeType;

    private final String expression;

    private final String name;

    private final List<ExpressNode> children = new ArrayList<>();

    public ExpressNode(ExpressNodeType nodeType, String expression,String name) {
        this.nodeType = nodeType;
        this.expression = expression;
        this.name = name;
    }

    public ExpressNode createExpressNode(ExpressNodeType expressNodeType, String expression,String name) {
        return new ExpressNode(expressNodeType, expression,name);
    }

    private void addChild(ExpressNode child) {
        if (child == null) {
            return;
        }
        this.children.add(child);
    }

    public ExpressNodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(ExpressNodeType nodeType) {
        this.nodeType = nodeType;
    }

    public String getExpression() {
        return expression;
    }

    public List<ExpressNode> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}
