package com.aibaixun.expresstion.node;

import java.util.ArrayList;
import java.util.List;

public class ExpressNode {
    
    private ExpressNodeType nodeType;

    private final String expression;
    
    private final List<ExpressNode> children = new ArrayList<>();

    public ExpressNode(ExpressNodeType nodeType, String expression) {
        this.nodeType = nodeType;
        this.expression = expression;
    }
    
    public ExpressNode createExpressNode(ExpressNodeType expressNodeType, String expression) {
        return new ExpressNode(expressNodeType, expression);
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
}
