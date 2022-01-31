package com.justintu.api.exception;

public abstract class AbstractException extends RuntimeException {
    private String code;

    public AbstractException(String code) {
        this.code = code;
    }

    public String getId() {
        return code;
    }

    public void setId(String id) {
        this.code = code;
    }
}
