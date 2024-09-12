package com.ittovative.demokafkatodb.service;

import com.ittovative.demokafkatodb.entity.Student;
import com.ittovative.demokafkatodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@EnableKafka
@Service
class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @KafkaListener(topics = "student", groupId = "1")
    public void saveFromKafka(Student student) {
        studentRepository.save(student);
    }
}
