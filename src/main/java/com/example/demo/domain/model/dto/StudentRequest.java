package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Student;

public class StudentRequest {
    public String name;
    public int grade;

    public StudentRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student toEntity() {
        Student student = new Student();
        student.setName(this.name);
        student.setGrade(this.grade);
        return student;
    }
}
