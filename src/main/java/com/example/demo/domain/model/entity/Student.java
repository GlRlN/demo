package com.example.demo.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    /*
    id | name
     */

    private String name;
    private int grade;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
