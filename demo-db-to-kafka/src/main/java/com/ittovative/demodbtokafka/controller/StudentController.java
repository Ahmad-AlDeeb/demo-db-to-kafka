package com.ittovative.demodbtokafka.controller;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.service.StudentService;
import com.ittovative.demodbtokafka.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Student controller for sending students to Kafka.
 */
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Get student from database and send him to Kafka Topic.
     *
     * @param id the id
     * @return response of sending a student to Kafka
     */
    @GetMapping("/students/kafka/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentToKafka(@PathVariable("id") Integer id) {
        Student student = studentService.findById(id);

        studentService.sendToKafka(student);

        ApiResponse<Student> apiResponse =
                new ApiResponse<>(null, HttpStatus.OK.value(), "Send Student " + id + " to Kafka");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
