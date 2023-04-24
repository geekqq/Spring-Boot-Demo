package com.geekkk.springdemo.error;

import org.springframework.http.HttpStatus;

public class ErrorMsg {
    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMsg() {
    }

    public ErrorMsg(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
