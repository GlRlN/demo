package com.example.demo.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private String name;
    private int price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
