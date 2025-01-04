package com.library.api_library.exceptions.models;

public class ErrorModel {
    
    private String message;
    private String error;
    private String timestamp;
    private Integer statusCode;

    public ErrorModel() {
    }

    public ErrorModel(String message, String error, String timestamp, Integer statusCode) {
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
