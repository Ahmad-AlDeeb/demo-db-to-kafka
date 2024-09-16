package com.ittovative.demodbtokafka.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.exception.StudentSerializationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.ittovative.demodbtokafka.constant.KafkaConstant.TOPIC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@DisplayName("Student Serializer")
@SuppressWarnings("checkstyle:MethodName")
class StudentSerializerTest {

    private final String expectedSerializedStudent = "{id\":1,\"firstName\":\"Duffie\",\"lastName\":\"Ewers\"}";
    private byte[] bytes;
    private Student student;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private StudentSerializer studentSerializer;

    @BeforeEach
    void init() {
        openMocks(this);
        student = new Student(1, "Duffie", "Ewers");
        bytes = expectedSerializedStudent.getBytes();
    }

    @Test
    @DisplayName("Serialize student when objectMapper succeed")
    void Should_SerializeStudent_When_ObjectMapperSucceed() throws JsonProcessingException {
        when(objectMapper.writeValueAsBytes(any(Student.class))).thenReturn(bytes);
        studentSerializer.serialize(anyString(), student);

        assertEquals(new String(bytes), expectedSerializedStudent, "Student serialization failed!");
        verify(objectMapper, times(1)).writeValueAsBytes(any(Student.class));
    }

    @Test
    @DisplayName("Throw exception when objectMapper fails")
    void Should_ThrowException_When_ObjectMapperFails() throws JsonProcessingException {
        when(objectMapper.writeValueAsBytes(any(Student.class))).thenThrow(StudentSerializationException.class);

        assertThrows(StudentSerializationException.class, () -> studentSerializer.serialize(TOPIC, student));
        verify(objectMapper, times(1)).writeValueAsBytes(any(Student.class));
    }
}
