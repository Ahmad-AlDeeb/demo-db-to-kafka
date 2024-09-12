package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;

/**
 * The interface Student service for getting all students sending them to Kafka.
 */
public interface StudentService {
    /**
     * Find student by its id .
     *
     * @param id the id of the student
     * @return the student with the specified id
     */
    Student findById(Integer id);

    /**
     * Send list of students in a batch to Kafka topic.
     */
    void sendToKafka();
}
