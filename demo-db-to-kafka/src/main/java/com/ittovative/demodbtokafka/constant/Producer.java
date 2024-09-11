package com.ittovative.demodbtokafka.constant;

public final class Producer {
    public static final String BOOTSTRAP_SERVERS = "localhost:19092";
    public static final String KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    public static final String VALUE_SERIALIZER = "org.springframework.kafka.support.serializer.JsonSerializer";
    public static final String ACKS = "all";
    public static final Integer RETRIES = 0;
    public static final Integer BATCH_SIZE = 16384;
    public static final Integer LINGER_MS = 1;
    public static final Integer BUFFER_MEMORY = 33554432;

    private Producer() {
    }
}
