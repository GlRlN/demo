package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    List<Student> findByGrade(int grade);
}
