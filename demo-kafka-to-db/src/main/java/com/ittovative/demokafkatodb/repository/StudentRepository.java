package com.ittovative.demokafkatodb.repository;

import com.ittovative.demokafkatodb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
