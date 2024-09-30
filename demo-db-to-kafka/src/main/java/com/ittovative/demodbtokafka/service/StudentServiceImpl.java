package com.ittovative.demodbtokafka.service;

import com.ittovative.demodbtokafka.entity.Student;
import com.ittovative.demodbtokafka.exception.StudentNotFoundException;
import com.ittovative.demodbtokafka.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ittovative.demodbtokafka.constant.ExceptionConstant.RESOURCE_NOT_FOUND_MESSAGE;
import static com.ittovative.demodbtokafka.constant.KafkaConstant.TOPIC;
import static com.ittovative.demodbtokafka.constant.SchedulerConstant.FIXED_DELAY;
import static java.lang.String.format;

@Service
@EnableScheduling
class StudentServiceImpl implements StudentService {
    private static final String RESOURCE_NAME = Student.class.getSimpleName();
    private static final String FIELD_ID = "id";

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
            throw new StudentNotFoundException(format(RESOURCE_NOT_FOUND_MESSAGE, RESOURCE_NAME, FIELD_ID, id));
        }

        return student;
    }

    @Override
    @Scheduled(fixedDelay = FIXED_DELAY)
    public void sendToKafka() {
        kafkaTemplate.send(TOPIC, findById(studentId++));
    }
}
