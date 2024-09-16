package com.ittovative.demodbtokafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static com.ittovative.demodbtokafka.constant.KafkaConstant.BOOTSTRAP_SERVERS;
import static com.ittovative.demodbtokafka.constant.KafkaConstant.TOPIC;

/**
 * Configuration of creating Kafka topics.
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * KafkaAdmin will automatically add topics for all beans of type NewTopic.
     *
     * @return KafkaAdmin
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();

        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);

        return new KafkaAdmin(configs);
    }

    /**
     * student topic which will have students data.
     *
     * @return student topic
     */
    @Bean
    public NewTopic studentTopic() {
        return new NewTopic(TOPIC, 1, (short) 1);
    }
}
