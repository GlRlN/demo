package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Student;

public class StudentRequest {
    public String name;
    public StudentRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student toEntity(){
        Student student = new Student();
        student.setName(name);
        return student;
    }
}
