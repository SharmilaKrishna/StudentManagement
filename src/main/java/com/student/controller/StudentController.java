package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Student Controller", description = "The Student Controller provides CRUD operations for Students")
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
    private StudentService studentService;
	
	@Operation(summary = "Get all students", description = "Retrieves a list of all students")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
	@Operation(summary = "Get a student by ID", description = "Retrieves a student based on their ID")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    
    @Operation(summary = "Add a new student", description = "Creates a new student and saves it to the database")
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @Operation(summary = "Update a student", description = "Update a student from the database by ID")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
    
    
    @Operation(summary = "Delete a student", description = "Deletes a student from the database by ID")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}



