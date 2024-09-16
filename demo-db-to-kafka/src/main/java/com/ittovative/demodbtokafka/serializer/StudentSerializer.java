package com.ittovative.demodbtokafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.exception.StudentSerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class StudentSerializer implements Serializer<Student> {
    private final ObjectMapper objectMapper;

    public StudentSerializer() {
        this.objectMapper = new ObjectMapper();  // For production
    }

    public StudentSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper; // For testing
    }

    @Override
    public byte[] serialize(String topic, Student student) {
        try {
            return objectMapper.writeValueAsBytes(student);
        } catch (Exception e) {
            throw new StudentSerializationException("Error serializing Student!", e);
        }
    }
}
