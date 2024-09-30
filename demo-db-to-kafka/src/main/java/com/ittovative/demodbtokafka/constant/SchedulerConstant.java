package com.ittovative.demodbtokafka.constant;

import static com.ittovative.demodbtokafka.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class SchedulerConstant {
    public static final int FIXED_DELAY = 400;

    private SchedulerConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
