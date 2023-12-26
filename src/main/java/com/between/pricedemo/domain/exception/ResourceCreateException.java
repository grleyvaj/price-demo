package com.between.pricedemo.domain.exception;

public class ResourceCreateException extends Exception {

    public ResourceCreateException(Throwable cause) {
        super(cause);
    }

    public ResourceCreateException(String message) {
        super(message);
    }

}
