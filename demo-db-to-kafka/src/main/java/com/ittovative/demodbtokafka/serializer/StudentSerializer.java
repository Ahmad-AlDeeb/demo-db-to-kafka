package com.ittovative.demodbtokafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittovative.demodbtokafka.entity.Student;
import org.apache.kafka.common.serialization.Serializer;

public class StudentSerializer implements Serializer<Student> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Student student) {
        try {
            return objectMapper.writeValueAsBytes(student);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing Student", e);
        }
    }
}
