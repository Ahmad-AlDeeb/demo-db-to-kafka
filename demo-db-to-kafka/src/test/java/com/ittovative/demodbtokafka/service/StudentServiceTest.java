package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.exception.StudentNotFoundException;
import com.ittovative.demodbtokafka.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Student Service")
@ExtendWith(MockitoExtension.class)
@SuppressWarnings("checkstyle:MethodName")
class StudentServiceTest {

    private final Integer expectedId = 1;
    private final String expectedFirstName = "Duffie";
    private final String expectedLastName = "Ewers";
    private Student student;

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private KafkaTemplate<String, Student> kafkaTemplate;
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void init() {
        student = new Student(expectedId, expectedFirstName, expectedLastName);
    }

    @Nested
    @DisplayName("Find student by id")
    class FindByIdTest {

        @Test
        @DisplayName("Find student when student exists")
        void Should_FindStudent_When_StudentExists() {
            when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
            studentService.findById(anyInt());

            assertAll("Assert it's exactly the same student",
                    () -> assertNotNull(student, "Student is null"),
                    () -> assertEquals(expectedId, student.getId(), "Student id mismatch"),
                    () -> assertEquals(expectedFirstName, student.getFirstName(), "First name mismatch"),
                    () -> assertEquals(expectedLastName, student.getLastName(), "Last name mismatch")
            );
            verify(studentRepository, times(1)).findById(anyInt());
        }

        @Test
        @DisplayName("Throw exception when student does not exist")
        void Should_ThrowException_When_StudentDoesNotExist() {
            when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());
            assertThrows(StudentNotFoundException.class, () -> studentService.findById(expectedId));
            verify(studentRepository, times(1)).findById(anyInt());
        }
    }

    @Nested
    @DisplayName("Send student to Kafka")
    class SendToKafkaTest {

        @Test
        @DisplayName("Send student to Kafka when student exists")
        void Should_SendStudentToKafka_When_StudentExists() {
            when(studentRepository.findById(anyInt())).thenReturn(Optional.of(student));
            studentService.sendToKafka();

            verify(studentRepository, times(1)).findById(anyInt());
            verify(kafkaTemplate, times(1)).send(anyString(), any(Student.class));
        }

        @Test
        @DisplayName("Throw exception when student does not exist")
        void Should_ThrowException_When_StudentDoesNotExist() {
            when(studentRepository.findById(anyInt())).thenReturn(Optional.empty());
            assertThrows(StudentNotFoundException.class, () -> studentService.sendToKafka());

            verify(studentRepository, times(1)).findById(anyInt());
            verify(kafkaTemplate, never()).send(anyString(), any(Student.class));
        }
    }
}
