package com.example.Student.repository;

import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT * FROM Student ")
    public List<Student> findAllStudents();
    @Query("SELECT * FROM Student WHERE id = :id")
    public Student findStudentById(@Param("id") int id);
    @Modifying
    @Query("DELETE * FROM Student WHERE id = :id")
    public void deleteStudentById(@Param("id") int id);
    @Query("SELECT * FROM Student WHERE lastName = :lastName")
    public List<Student> findByLastName(@Param("lastName") String lastName);
    @Query("SELECT * FROM Student WHERE firstName = :firstName")
    public List<Student> findByFirstName(@Param("firstName") String firstName);
    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findByAgeGreaterThan(@Param("age") Integer age);
    @Query("SELECT * FROM Student WHERE active = true")
    List<Student> findByActive();
    @Query("SELECT * FROM Student WHERE active = false")
    List<Student> findByFalse();
}
