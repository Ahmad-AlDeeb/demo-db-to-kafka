package com.ittovative.demokafkatodb.derserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittovative.demokafkatodb.deserializer.StudentDeserializer;
import com.ittovative.demokafkatodb.entity.Student;
import com.ittovative.demokafkatodb.exception.StudentDeserializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;

import static com.ittovative.demokafkatodb.constant.KafkaConstant.TOPIC;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@DisplayName("Student Deserializer")
@SuppressWarnings("checkstyle:MethodName")
class StudentDeserializerTest {

    private final Integer expectedId = 1;
    private final String expectedFirstName = "Duffie";
    private final String expectedLastName = "Ewers";
    private Student student;
    private byte[] bytes;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private StudentDeserializer studentDeserializer;

    @BeforeEach
    void init() {
        openMocks(this);
        student = new Student(expectedId, expectedFirstName, expectedLastName);
        bytes = "{id\":1,\"firstName\":\"Duffie\",\"lastName\":\"Ewers\"}".getBytes();
    }

    @Test
    @DisplayName("Deserialize to student when objectMapper succeed")
    void Should_DeserializeStudent_When_ObjectMapperSucceed() throws IOException {
        when(objectMapper.readValue(bytes, Student.class)).thenReturn(student);
        studentDeserializer.deserialize(TOPIC, bytes);

        assertAll("Assert it's exactly the same student",
                () -> assertNotNull(student, "Student is null"),
                () -> assertEquals(expectedId, student.getId(), "Student id mismatch"),
                () -> assertEquals(expectedFirstName, student.getFirstName(), "First name mismatch"),
                () -> assertEquals(expectedLastName, student.getLastName(), "Last name mismatch")
        );
        verify(objectMapper, times(1)).readValue(bytes, Student.class);
    }

    @Test
    @DisplayName("Throw exception when objectMapper fails")
    void Should_ThrowException_When_ObjectMapperFails() throws IOException {
        when(objectMapper.readValue(bytes, Student.class)).thenThrow(StudentDeserializationException.class);

        assertThrows(StudentDeserializationException.class, () -> studentDeserializer.deserialize(TOPIC, bytes));
        verify(objectMapper, times(1)).readValue(bytes, Student.class);
    }
}
