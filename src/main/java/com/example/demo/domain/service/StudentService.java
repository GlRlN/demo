package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.StudentRequest;
import com.example.demo.domain.model.entity.Student;
import com.example.demo.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getAllStudentsByGrade(int grade) {
        return studentRepository.findByGrade(grade);
    }

    public void saveStudent(StudentRequest studentRequest) {
        studentRepository.save(studentRequest.toEntity());
    }
}
