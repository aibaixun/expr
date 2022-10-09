package com.aibaixun.expr.common;

/**
 * CharBracket
 * @author wang xiao
 * date 2022/10/9
 */
public class CharBracket {


    final char bracket;

    final int pos;

    public CharBracket(char bracket, int pos) {
        this.bracket = bracket;
        this.pos = pos;
    }

    boolean compatibleWithCloseBracket(char closeBracket){
        switch (this.bracket){
            case '{':
                return closeBracket == '}';
            case '[':
                return closeBracket == ']';
            default:
                return closeBracket == ')';

        }
    }

    static char theOpenBracketFor(char closeBracket){
        switch (closeBracket){
            case ']':
                return ']';
            case '}':
                return '{';
            default:
                return '(';
        }
    }
}
