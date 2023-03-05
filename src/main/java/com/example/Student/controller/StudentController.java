package com.example.Student.controller;

import com.example.Student.service.StudentService;
import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }
    @PostMapping("/add-Student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.created(URI.create("/students/" + createdStudent.getId())).body(createdStudent);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudent(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/get_all")
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> student = studentService.getAllStudents();
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping("/getStudentsByAgeGreaterThan/{age}")
    public ResponseEntity<List<Student>> getStudentsByAgeGreaterThan(@PathVariable int age) {
        List<Student> student = studentService.getStudentsByAgeGreaterThan(age);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping("/getBy_FirstName/{firstName}")
    public ResponseEntity<List<Student>> getByFirstName(@PathVariable String firstName) {
        List<Student> student = studentService.getByFirstName(firstName);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping("/findBy_LastName/{lastName}")
    public ResponseEntity<List<Student>> findByLastName(@PathVariable String lastName) {
        List<Student> student = studentService.findByLastName(lastName);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping("/get_ActiveStudents")
    public ResponseEntity<List<Student>> getActiveStudents() {
        List<Student> student = studentService.getActiveStudents();
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @GetMapping("/get_InactiveStudents")
    public ResponseEntity<List<Student>> getInactiveStudents() {
        List<Student> student = studentService.getInactiveStudents();
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}