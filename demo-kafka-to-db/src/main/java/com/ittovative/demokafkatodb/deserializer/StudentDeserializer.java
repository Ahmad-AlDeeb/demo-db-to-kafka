package com.ittovative.demokafkatodb.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittovative.demokafkatodb.entity.Student;
import org.apache.kafka.common.serialization.Deserializer;

public class StudentDeserializer implements Deserializer<Student> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Student deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Student.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing Student", e);
        }
    }
}
