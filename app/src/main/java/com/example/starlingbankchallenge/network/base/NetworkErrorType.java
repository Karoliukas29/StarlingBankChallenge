package com.example.starlingbankchallenge.network.base;

public enum NetworkErrorType {

    BAD_REQUEST("400"),
    NOT_AUTHORIZED("401"),
    FORBIDDEN("403"),
    NOT_FOUND("404"),
    NOT_ACCEPTABLE("406"),
    CONFLICT("409"),
    TOO_MANY_REQUEST("429"),
    SERVER_INTERNAL_ERROR("500"),
    SERVER_UNAVAILABLE("503");

    private String errorType;

    NetworkErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }

}
