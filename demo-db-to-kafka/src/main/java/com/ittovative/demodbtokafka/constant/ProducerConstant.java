package com.ittovative.demodbtokafka.constant;

import static com.ittovative.demodbtokafka.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class ProducerConstant {
    public static final String KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    public static final String VALUE_SERIALIZER = "com.ittovative.demodbtokafka.serializer.StudentSerializer";
    public static final String ACKS = "all";
    public static final Integer RETRIES = 0;
    public static final Integer BATCH_SIZE = 16384;
    public static final Integer LINGER_MS = 2000;
    public static final Integer BUFFER_MEMORY = 33554432;

    private ProducerConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
