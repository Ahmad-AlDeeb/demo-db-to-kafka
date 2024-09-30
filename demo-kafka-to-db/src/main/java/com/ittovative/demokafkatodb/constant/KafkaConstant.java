package com.ittovative.demokafkatodb.constant;

import static com.ittovative.demokafkatodb.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class KafkaConstant {
    public static final String BOOTSTRAP_SERVERS = "localhost:19092";
    public static final String TOPIC = "student";

    private KafkaConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
