package com.ittovative.demokafkatodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Get students data from Kafka topic to database.
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
public class DemoKafkaToDbApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoKafkaToDbApplication.class, args);
    }

}
