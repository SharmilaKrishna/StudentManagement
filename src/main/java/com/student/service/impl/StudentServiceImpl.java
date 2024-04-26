package com.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	  @Autowired 
	  private StudentRepository studentRepository;
	 

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		return optionalStudent.orElse(null);
	}

	@Override
	public ResponseEntity<Student> addStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		/*
		 * if (studentRepository.existsById(id)) { student.setId(id); return
		 * studentRepository.save(student); }
		 */
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
