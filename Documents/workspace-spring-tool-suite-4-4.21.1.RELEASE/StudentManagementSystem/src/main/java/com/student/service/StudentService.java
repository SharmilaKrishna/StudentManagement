package com.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.student.model.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student getStudentById(Long id);

	ResponseEntity<Student> addStudent(Student student);

	Student updateStudent(Long id, Student student);

	void deleteStudent(Long id);
}
