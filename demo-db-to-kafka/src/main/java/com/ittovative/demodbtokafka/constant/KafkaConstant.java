package com.ittovative.demodbtokafka.constant;

import static com.ittovative.demodbtokafka.constant.ExceptionConstant.UTILITY_CLASS_INSTANTIATION_MESSAGE;

public final class KafkaConstant {
    public static final String BOOTSTRAP_SERVERS = "localhost:19092";
    public static final String TOPIC = "student";
    public static final int NUMBER_OF_PARTITIONS = 1;
    public static final int REPLICATION_FACTOR = 1;

    private KafkaConstant() {
        throw new IllegalStateException(UTILITY_CLASS_INSTANTIATION_MESSAGE);
    }
}
