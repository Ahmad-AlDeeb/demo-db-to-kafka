package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.exception.StudentNotFoundException;
import com.ittovative.demodbtokafka.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Student Service")
class StudentServiceImplTest {
    private final Integer expectedId = 1;
    private final String expectedFirstName = "Duffie";
    private final String expectedLastName = "Ewers";
    private Student actualStudent;

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void init() {
        actualStudent = new Student();
        actualStudent.setId(expectedId);
        actualStudent.setFirstName(expectedFirstName);
        actualStudent.setLastName(expectedLastName);
    }

    @Test
    @SuppressWarnings("checkstyle:MethodName")
    @DisplayName("Find student when student exists")
    void Should_FindStudent_When_StudentExists() {

        when(studentRepository.findById(expectedId)).thenReturn(Optional.of(actualStudent));
        studentService.findById(expectedId);

        assertAll("Assert it's exactly the same student",
                () -> assertNotNull(actualStudent, "Student is null"),
                () -> assertEquals(expectedId, actualStudent.getId(), "Student id mismatch"),
                () -> assertEquals(expectedFirstName, actualStudent.getFirstName(), "First name mismatch"),
                () -> assertEquals(expectedLastName, actualStudent.getLastName(), "Last name mismatch")
        );
        verify(studentRepository, times(1)).findById(expectedId);
    }

    @Test
    @SuppressWarnings("checkstyle:MethodName")
    @DisplayName("Throw exception when student does not exist")
    void Should_ThrowException_When_StudentDoesNotExist() {

        when(studentRepository.findById(expectedId)).thenReturn(Optional.empty());
        assertThrows(StudentNotFoundException.class, () -> studentService.findById(expectedId));
        verify(studentRepository, times(1)).findById(expectedId);
    }
}
