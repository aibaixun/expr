package com.aibaixun.expresstion.node;

public interface ExpressDataNode {

    void setNodeType(ExpressNodeType expressNodeType);

    ExpressNodeType getNodeType(ExpressNodeType expressNodeType);

    void setChild(ExpressDataNode ref);

    String getValue();

    ExpressDataNode createExpressNode(ExpressNodeType expressNodeType, String expression);
}
