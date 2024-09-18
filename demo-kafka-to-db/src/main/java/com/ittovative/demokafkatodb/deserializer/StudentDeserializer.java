package com.ittovative.demokafkatodb.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittovative.demokafkatodb.entity.Student;
import com.ittovative.demokafkatodb.exception.StudentDeserializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class StudentDeserializer implements Deserializer<Student> {

    private final ObjectMapper objectMapper;

    public StudentDeserializer() {
        this.objectMapper = new ObjectMapper();  // For production
    }

    public StudentDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper; // For testing
    }

    @Override
    public Student deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Student.class);
        } catch (Exception e) {
            throw new StudentDeserializationException("Error deserializing Student!", e);
        }
    }
}
