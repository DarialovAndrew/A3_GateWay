package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public final class Apparatus {
    boolean free = true;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private int age;

    public Apparatus() {
        name = "";
    }


    public Apparatus(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setFree() {
        this.free = true;
    }

    public String getName() {
        return name;
    }

    public void setNotFree() {
        this.free = false;
    }

    public String toString() {
        return this.name + " age: " + this.age + " is free?: " + this.free + "\n";
    }
}
