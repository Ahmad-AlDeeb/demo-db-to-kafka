package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ittovative.demodbtokafka.constant.Scheduler.FIXED_DELAY;

@Service
@EnableScheduling
class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final KafkaTemplate<String, Student> kafkaTemplate;
    private int studentId = 1;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository, KafkaTemplate<String, Student> kafkaTemplate) {
        this.studentRepository = studentRepository;
        this.kafkaTemplate = kafkaTemplate;
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
    @Scheduled(fixedDelay = FIXED_DELAY)
    public void sendToKafka() {
        kafkaTemplate.send("student", findById(studentId++));
    }
}
