package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void sendBatchToKafka(List<Student> students) {
        for (Student student : students) {
            kafkaTemplate.send("student", student);
        }
    }
}
