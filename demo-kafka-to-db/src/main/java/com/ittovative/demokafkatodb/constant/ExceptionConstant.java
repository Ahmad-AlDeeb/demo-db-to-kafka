package com.ittovative.demokafkatodb.constant;

public final class ExceptionConstant {
    public static final String UTILITY_CLASS_INSTANTIATION_MESSAGE = "Utility class should not be instantiated!";
    public static final String DESERIALIZING_STUDENT_ERROR_MESSAGE = "Error deserializing Student!";

    private ExceptionConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
