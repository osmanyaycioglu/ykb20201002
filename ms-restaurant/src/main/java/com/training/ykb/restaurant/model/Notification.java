package com.training.ykb.restaurant.model;


public class Notification {

    private String number;
    private String message;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    @Override
    public String toString() {
        return "Notification [number=" + this.number + ", message=" + this.message + "]";
    }


}
