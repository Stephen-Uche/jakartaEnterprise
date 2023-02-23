package com.example.jakartaee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name can't be null")
    @Size(min = 2)
    String name;

    //@JsonbTransient
    String secretRecepie = "This shouldn't be visible";

    public String getSecretRecepie() {
        return secretRecepie;
    }

    public void setSecretRecepie(String secretRecepie) {
        this.secretRecepie = secretRecepie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
