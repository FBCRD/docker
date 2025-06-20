package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Usuario() {
    }

    public Usuario(String name) {
        this.name = name;

    }

    // Getters e Setters
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }



}
