package com.ittovative.demodbtokafka.repository;

import com.ittovative.demodbtokafka.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
