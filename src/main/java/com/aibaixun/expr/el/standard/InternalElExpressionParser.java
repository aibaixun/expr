package com.aibaixun.expr.el.standard;

import com.aibaixun.expr.ExprParserContext;
import com.aibaixun.expr.ExprParserException;
import com.aibaixun.expr.common.TemplateExprParser;
import com.aibaixun.expr.el.ElExpr;
import com.aibaixun.expr.el.ElExprParserConfig;
import com.aibaixun.expr.el.ast.ElNodeImpl;

import java.util.*;

/**
 * @author wang xiao
 * date 2022/10/20
 */
public class InternalElExpressionParser extends TemplateExprParser {

     private final ElExprParserConfig  parserConfig;

     private final Deque<ElNodeImpl> constructedElNodes = new ArrayDeque<>();

     private List<Token> tokenList = Collections.emptyList();

     private String expression = "";

    private int tokenListLength;
    private int tokenListPointer;


    public InternalElExpressionParser(ElExprParserConfig parserConfig) {
        this.parserConfig = parserConfig;
    }

    @Override
    protected ElExpr doParseExpression(String expression, ExprParserContext context) throws ExprParserException {
        this.expression = expression;
        Tokenizer tokenizer = new Tokenizer(expression);
        this.tokenList = tokenizer.process();
        this.tokenListLength = this.tokenList.size();
        this.tokenListPointer = 0;
        this.constructedElNodes.clear();
        ElNodeImpl ast = this.parserElNode();
        return new ElExpr(expression,ast);
    }


    /**
     * 解析节点
     * @return ElNode
     */
    private ElNodeImpl parserElNode(){
        ElNodeImpl logicOrExpr =  this.parseLogicalOrExpression();
        Token t = this.peekToken();
        if (Objects.nonNull(t)){

        }
        return logicOrExpr;
    }




    private ElNodeImpl parseLogicalOrExpression (){
        Token token = this.peekToken();
        if (Objects.isNull(token)){

        }
        return null;
    };



    private Token peekToken() {
        return this.tokenListPointer >= this.tokenListLength ? null : (Token)this.tokenList.get(this.tokenListPointer);
    }
    public ElExprParserConfig getParserConfig() {
        return parserConfig;
    }


}
