package com.ittovative.demodbtokafka.controller;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.service.StudentService;
import com.ittovative.demodbtokafka.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Student controller for sending batch of students.
 */
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Gets batch of students to kafka.
     *
     * @return the student batch to kafka
     */
    @GetMapping("/students/kafka")
    public ResponseEntity<ApiResponse<Student>> getStudentBatchToKafka() {
        List<Student> students = studentService.findAll();

        studentService.sendBatchToKafka(students);

        ApiResponse<Student> apiResponse =
                new ApiResponse<>(null, HttpStatus.OK.value(), "Students batch sent to Kafka");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
