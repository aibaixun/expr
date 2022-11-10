package com.aibaixun.expr.el.standard;

/**
 * @author wang xiao
 * date 2022/10/17
 */
 class Token {
     TokenType tokenType;
    String data;
    int startPos;
    int endPos;

    public Token(TokenType tokenType, int startPos, int endPos) {
        this.tokenType = tokenType;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Token(TokenType tokenType, String data, int startPos, int endPos) {
        this.tokenType = tokenType;
        this.data = data;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Token(TokenType tokenKind, char[] tokenData, int startPos, int endPos) {
        this(tokenKind, startPos, endPos);
        this.data = new String(tokenData);
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }
}
