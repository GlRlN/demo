package com.example.demo.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.aspectj.lang.annotation.RequiredTypes;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Student {
    /*
    id | name
     */

    private String name;
    private int grade;

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
