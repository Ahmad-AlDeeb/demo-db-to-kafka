package com.ittovative.demokafkatodb.service;

import com.ittovative.demokafkatodb.entity.Student;

import java.util.List;

/**
 * The interface Student service for saving students from Kafka topic into database.
 */
public interface StudentService {

    /**
     * Save students from Kafka into database.
     *
     * @param students the students
     */
    void saveFromKafka(List<Student> students);
}
