package com.training.ykb.common.error;


public class MyRestException extends Exception {

    private static final long serialVersionUID = -4448252942819395421L;

    private ErrorObject       errorObject;

    public MyRestException(final ErrorObject errorObjectParam) {
        super();
        this.errorObject = errorObjectParam;
    }

    public MyRestException() {
    }

    public ErrorObject getErrorObject() {
        return this.errorObject;
    }

    public void setErrorObject(final ErrorObject errorObjectParam) {
        this.errorObject = errorObjectParam;
    }


}
