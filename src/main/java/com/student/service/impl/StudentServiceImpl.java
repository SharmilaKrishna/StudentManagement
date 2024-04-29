package com.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

  	@Override
    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all students: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Student getStudentById(Long id) {
        try {
            logger.info("Fetching student by id: {}", id);
            Optional<Student> optionalStudent = studentRepository.findById(id);
            logger.info("Fetched student by id: {}", optionalStudent);
            return optionalStudent.orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching student by id {}: {}", id, e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseEntity<Student> addStudent(Student student) {
        try {
            Student savedStudent = studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } catch (Exception e) {
            logger.error("Error occurred while adding student: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        // Implementation for updateStudent method
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error occurred while deleting student with id {}: {}", id, e.getMessage());
        }
    }

}
