package com.example.Student.service;

import com.example.Student.repository.StudentRepository;
import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(int id, Student student) {
        Student studenT = studentRepository.findById(id).orElse(null);
        if (studenT == null) {
            return null;
        }
        studenT.setFirstName(student.getFirstName());
        studenT.setLastName(student.getLastName());
        studenT.setAge(student.getAge());
        studenT.setActive(student.getActive());
        studenT.setAdmissionDate(student.getAdmissionDate());
        return studentRepository.save(studenT);
    }
    public boolean deleteStudent(int id) {
        Student studenT = studentRepository.findById(id).orElse(null);
        if (studenT == null) {
            return false;
        }
        studentRepository.delete(studenT);
        return true;
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public List<Student> getStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }
    public List<Student> getStudentsByAgeGreaterThan(Integer age) {
        return studentRepository.findByAgeGreaterThan(age);
    }
    public List<Student> getActiveStudents() {
        return studentRepository.findByActive();
    }
    public List<Student> getInactiveStudents() {
        return studentRepository.findByFalse();
    }
    public List<Student> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }
}