package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public final class Shower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int number;
    private boolean free;

    public Shower(int number, boolean free) {
        this.number = number;
        this.free = free;
    }

    public Shower() {
        number = -1;
    }

    public UUID getId() {
        return id;
    }

    public void setFree() {
        this.free = true;
    }

    public void setNotFree() {
        this.free = false;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "Shower number: " + this.number + " is free?: " + this.free + "\n";
    }
}
