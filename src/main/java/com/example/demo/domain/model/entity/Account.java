package com.example.demo.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Account {

    private String id;
    private String password;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
}
