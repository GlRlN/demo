package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Student;
import lombok.Getter;
import lombok.Setter;

public class StudentRequest {
    public String name;
    public int grade;

    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }

    public StudentRequest() {
    }


    public Student toEntity(){
        Student student = new Student();
        student.setName(this.name);
        student.setGrade(this.grade);
        return student;
    }
}
