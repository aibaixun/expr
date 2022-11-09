package com.aibaixun.expr.el.ast;

import com.aibaixun.expr.ExprEvalException;
import com.aibaixun.expr.el.ElNode;
import com.aibaixun.expr.el.ExpressionState;

/**
 * @author wang xiao
 * date 2022/11/9
 */
public class ElNodeImpl implements ElNode {

    private static final ElNodeImpl [] NO_CHILDREN = new ElNodeImpl[0];

    private final int startPos;

    private final int endPos;

    private ElNodeImpl parent;

    protected ElNodeImpl [] children = ElNodeImpl.NO_CHILDREN;

    public ElNodeImpl(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public Object getValue(ExpressionState expressionState) throws ExprEvalException {
        return null;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public ElNodeImpl getParent() {
        return parent;
    }

    public ElNodeImpl[] getChildren() {
        return children;
    }
}
