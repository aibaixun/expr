package com.aibaixun.expr.el.ast;

import com.aibaixun.expr.ExprEvalException;
import com.aibaixun.expr.el.ElExprEvalException;
import com.aibaixun.expr.el.ElNode;
import com.aibaixun.expr.el.ExpressionState;

import java.util.Objects;

/**
 * @author wang xiao
 * date 2022/11/9
 */
public abstract class ElNodeImpl implements ElNode {

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
        return getValueInternal(expressionState);
    }

    /**
     * 获取变量
     * @param expressionState expression state
     * @return Object value
     * @throws ExprEvalException exception
     */
    protected abstract Object getValueInternal(ExpressionState expressionState) throws ExprEvalException;

    @Override
    public boolean isWriteable(ExpressionState expressionState) throws ExprEvalException {
        return false;
    }

    @Override
    public void setValue(ExpressionState expressionState, Object value) throws ExprEvalException {
        throw new ElExprEvalException("not set value");
    }

    @Override
    public int getChildrenCount() {
        return this.children.length;
    }

    @Override
    public ElNode getChildren(int index) {
        return this.children[index];
    }

    @Override
    public Class<?> getObjectClass(Object obj) {
        if (Objects.isNull(obj)){
            return null;
        }
        return obj.getClass();
    }

    @Override
    public int getStartPos() {
        return startPos;
    }

    @Override
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
