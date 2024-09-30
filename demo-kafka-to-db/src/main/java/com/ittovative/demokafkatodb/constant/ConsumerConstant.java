package com.ittovative.demokafkatodb.constant;

import static com.ittovative.demokafkatodb.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class ConsumerConstant {
    public static final String GROUP_ID = "1";
    public static final String MAX_POLL_RECORDS = "5";

    private ConsumerConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
