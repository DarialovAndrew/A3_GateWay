package com.example.demo.model;

import java.util.UUID;


public final class Client {
    private final String name;
    private final boolean VIP;
    private UUID id;
    private boolean present;

    public Client(String name, boolean present, boolean VIP) {
        this.name = name;
        this.present = present;
        this.VIP = VIP;
    }

    public Client() {
        name = "";
        VIP = false;
    }

    public UUID getId() {
        return id;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public void work(Apparatus apparatus) {
        System.out.println(this.name + " I am working on: " + apparatus.getName());
        apparatus.setNotFree();
    }

    public void train() {
        System.out.println(this.name + " I am training");
    }

    public String toString() {
        return this.name + " present: " + this.present + " VIP: " + this.VIP + "\n";
    }
}
