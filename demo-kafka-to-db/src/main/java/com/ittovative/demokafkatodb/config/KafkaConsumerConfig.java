package com.ittovative.demokafkatodb.config;

import com.ittovative.demokafkatodb.deserializer.StudentDeserializer;
import com.ittovative.demokafkatodb.entity.Student;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.ittovative.demokafkatodb.constant.ConsumerConstant.GROUP_ID;
import static com.ittovative.demokafkatodb.constant.ConsumerConstant.MAX_POLL_RECORDS;
import static com.ittovative.demokafkatodb.constant.KafkaConstant.BOOTSTRAP_SERVERS;

/**
 * Create and configure consumer to get students from Kafka.
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    /**
     * Consumer configuration.
     *
     * @return the consumer factory
     */
    @Bean
    public ConsumerFactory<String, Student> consumerFactory() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StudentDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, MAX_POLL_RECORDS);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    /**
     * Use consumer factory to listen on topics.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Student> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Student> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
