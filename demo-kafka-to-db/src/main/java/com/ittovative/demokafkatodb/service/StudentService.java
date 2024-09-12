package com.ittovative.demokafkatodb.service;

import com.ittovative.demokafkatodb.entity.Student;

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
     * @param student the student we will receive from Kafka topic and save to database.
     */
    void saveFromKafka(Student student);
}
