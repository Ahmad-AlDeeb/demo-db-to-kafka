package com.ittovative.demokafkatodb.exception;

public class StudentDeserializationException extends RuntimeException {
    public StudentDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
