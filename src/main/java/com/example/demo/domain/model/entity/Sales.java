package com.example.demo.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sales {
    private Date date;
    private int category;
    private int menu;
    private int price;
    private int quantity;
    private int device;
    private int ordernum;
    private int process;
    private int devicenum;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
