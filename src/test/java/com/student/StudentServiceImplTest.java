package com.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import com.student.service.impl.StudentServiceImpl;

public class StudentServiceImplTest {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "John Doe", "234", "Grade 10", "1234567890", "ABC School"));
        students.add(new Student(2L, "Jane Smith", "31","Grade 11", "9876543210", "XYZ School"));

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetStudentById_ExistingId() {
        Student student = new Student(2L, "John Doe","234", "Grade 10", "1234567890", "ABC School");
        when(studentRepository.findById(2L)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(2L);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testGetStudentById_NonExistingId() {
        when(studentRepository.findById(1L)).thenReturn(Optional.empty());

        Student result = studentService.getStudentById(1L);

        assertNull(result);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(1L, "John Doe","234", "Grade 10", "1234567890", "ABC School");
       
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        ResponseEntity<Student> response = studentService.addStudent(student);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

}
