package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;

import java.util.List;


/**
 * The interface Student service for getting all students sending them to Kafka.
 */
public interface StudentService {
    /**
     * Get all students.
     *
     * @return list of students
     */
    List<Student> findAll();

    /**
     * Send list of students in a batch to Kafka topic.
     *
     * @param students list of students to send in batch
     */
    void sendBatchToKafka(List<Student> students);
}
