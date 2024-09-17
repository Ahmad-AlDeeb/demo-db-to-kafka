package com.ittovative.demokafkatodb.service;

import com.ittovative.demokafkatodb.entity.Student;

import java.util.List;

/**
 * The interface Student service for saving students from Kafka topic into database.
 */
public interface StudentService {
    /**
     * Save student.
     *
     * @param student which will be saved to database.
     * @return the student
     */
    Student save(Student student);


    /**
     * Save students from Kafka into database.
     *
     * @param students the students
     */
    void saveFromKafka(List<Student> students);
}
