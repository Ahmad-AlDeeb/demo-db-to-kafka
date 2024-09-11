package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;

import java.util.List;


/**
 * The interface Student service for finding all students or one student by id.
 */
public interface StudentService {

    /**
     * Get all students.
     *
     * @return list of students
     */
    List<Student> findAll();

    /**
     * Find student by its id .
     *
     * @param id the id of the student
     * @return the student with the specified id
     */
    Student findById(Integer id);

    /**
     * Send student to Kafka Topic.
     *
     * @param student the student
     */
    void sendToKafka(Student student);
}
