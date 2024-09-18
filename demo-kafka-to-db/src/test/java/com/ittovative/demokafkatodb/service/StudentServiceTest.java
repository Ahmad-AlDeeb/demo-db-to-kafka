package com.ittovative.demokafkatodb.service;

import com.ittovative.demokafkatodb.entity.Student;
import com.ittovative.demokafkatodb.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DisplayName("Student Service")
@ExtendWith(MockitoExtension.class)
@SuppressWarnings("checkstyle:MethodName")
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    @DisplayName("Save students from Kafka when students exist")
    void Should_SaveStudentsFromKafka_When_StudentsExist() {
        List<Student> students = List.of(new Student(), new Student());

        studentService.saveFromKafka(students);
        verify(studentRepository, times(1)).saveAll(students);
    }
}
