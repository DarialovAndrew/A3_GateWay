package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public final class Manager {
    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int salary;

    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Manager() {
        name = "";
    }

    public UUID getId() {
        return id;
    }

    public void work() {
        System.out.println(this.name + " I am working ");
    }

    public String toString() {
        return this.name + " has salary: " + this.salary + "\n";
    }
}
