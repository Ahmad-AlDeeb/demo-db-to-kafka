package com.ittovative.demodbtokafka.constant;

public final class ExceptionConstant {
    public static final String UTILITY_CLASS_INSTANTIATION_MESSAGE = "Utility class should not be instantiated!";
    public static final String SERIALIZATION_ERROR_MESSAGE = "Error serializing Student!";
    public static final String RESOURCE_NOT_FOUND_MESSAGE = "%s with %s '%s' is not found!";

    private ExceptionConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
