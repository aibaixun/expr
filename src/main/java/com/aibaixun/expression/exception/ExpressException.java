package com.aibaixun.expresstion.exception;

public class ExpressException extends RuntimeException{

    public ExpressException(String message) {
        super(message);
    }

    public ExpressException(String message, Throwable cause) {
        super(message, cause);
    }
}
