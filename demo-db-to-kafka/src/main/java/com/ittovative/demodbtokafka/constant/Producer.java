package com.ittovative.demodbtokafka.constant;

public final class Producer {
    public static final String KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    public static final String VALUE_SERIALIZER = "com.ittovative.demodbtokafka.serializer.StudentSerializer";
    public static final String ACKS = "all";
    public static final Integer RETRIES = 0;
    public static final Integer BATCH_SIZE = 16384;
    public static final Integer LINGER_MS = 1000;
    public static final Integer BUFFER_MEMORY = 33554432;

    private Producer() {
    }
}
