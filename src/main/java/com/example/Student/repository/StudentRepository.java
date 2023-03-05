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

    @Query(value="SELECT * FROM Student ", nativeQuery = true)
    public List<Student> findAllStudents();
    @Query(value="SELECT * FROM Student WHERE id = :id", nativeQuery = true)
    public Student findStudentById(@Param("id") int id);
    @Modifying
    @Query(value="DELETE * FROM Student WHERE id = :id", nativeQuery = true)
    public void deleteStudentById(@Param("id") int id);
    @Query(value="SELECT * FROM Student WHERE lastName = :lastName", nativeQuery = true)
    public List<Student> findByLastName(@Param("lastName") String lastName);
    @Query(value="SELECT * FROM Student WHERE firstName = :firstName", nativeQuery = true)
    public List<Student> findByFirstName(@Param("firstName") String firstName);
    @Query(value="SELECT s FROM Student s WHERE s.age > :age", nativeQuery = true)
    List<Student> findByAgeGreaterThan(@Param("age") Integer age);
    @Query(value="SELECT * FROM Student WHERE active = true", nativeQuery = true)
    List<Student> findByActive();
    @Query(value="SELECT * FROM Student WHERE active = false", nativeQuery = true)
    List<Student> findByFalse();
}