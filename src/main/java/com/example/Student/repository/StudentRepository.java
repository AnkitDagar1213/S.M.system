package com.example.Student.repository;

import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value="SELECT * FROM students", nativeQuery = true)
    public List<Student> findAllStudents();
    @Query(value="SELECT * FROM students WHERE id = :id", nativeQuery = true)
    public Student findStudentById( int id);
    @Modifying
    @Query(value="DELETE * FROM students WHERE id = :id", nativeQuery = true)
    public void deleteStudentById( int id);
    @Query(value="SELECT * FROM students WHERE lastName = :lastName", nativeQuery = true)
    public List<Student> findByLastName( String lastName);
    @Query(value="SELECT * FROM students WHERE firstName = :firstName", nativeQuery = true)
    public List<Student> findByFirstName( String firstName);
    @Query(value="SELECT * FROM students WHERE age > :age", nativeQuery = true)
    List<Student> findByAgeGreaterThan( Integer age);
    @Query(value="SELECT * FROM students WHERE active = true", nativeQuery = true)
    List<Student> findByActive();
    @Query(value="SELECT * FROM students WHERE active = false", nativeQuery = true)
    List<Student> findByInactive();
}