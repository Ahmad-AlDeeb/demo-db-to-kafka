package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final KafkaTemplate<String, Student> kafkaTemplate;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository, KafkaTemplate<String, Student> kafkaTemplate) {
        this.studentRepository = studentRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> result = studentRepository.findById(id);

        Student student = null;

        if (result.isPresent()) {
            student = result.get();
        } else {
            throw new RuntimeException("Couldn't find student with id " + id);
        }

        return student;
    }

    @Override
    public void sendToKafka(Student student) {
        kafkaTemplate.send("student", student);
    }
}
