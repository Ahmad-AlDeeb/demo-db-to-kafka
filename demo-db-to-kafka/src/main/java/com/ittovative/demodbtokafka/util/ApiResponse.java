package com.ittovative.demodbtokafka.util;

public class ApiResponse<T> {
    private final T body;
    private final Integer statusCode;
    private final String message;

    public ApiResponse(T body, Integer statusCode, String message) {
        this.body = body;
        this.statusCode = statusCode;
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
