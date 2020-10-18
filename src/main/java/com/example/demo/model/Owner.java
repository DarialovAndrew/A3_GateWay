package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public final class Owner {
    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int profit;

    public Owner(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }

    public Owner() {
        name = "";
    }

    public UUID getId() {
        return id;
    }

    public void sayResults() {
        System.out.println("Current profit is:" + profit);
    }

    public void addMoney(int addition) {
        this.profit += addition;
    }

    public String toString() {
        return this.name + " has profit: " + this.profit + "\n";
    }
}
