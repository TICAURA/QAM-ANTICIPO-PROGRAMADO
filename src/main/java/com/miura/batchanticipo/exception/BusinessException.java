package com.miura.batchanticipo.exception;

public class BusinessException extends Exception {

    private String error;
    private int code;

    public BusinessException(String message, int code){
        super(message);
        this.error = message;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
