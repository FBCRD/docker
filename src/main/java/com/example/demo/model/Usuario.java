package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name= "users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
