package com.hustle.hustle.model.errors;

public class ErrorResponse {
    private String message;
    private int statusCode;

    // Constructors, getters, and setters

    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public ErrorResponse() {
    }

    public String getMessage(){
        return message;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setMessage(String string){
        this.message = message;
    }

    public void setStatusCode(int i){
        this.statusCode = statusCode;
    }


}
