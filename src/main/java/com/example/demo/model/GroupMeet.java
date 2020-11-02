package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public final class GroupMeet {

    private UUID id;
    private List<UUID> clients;
    private UUID trainer;
    private Date date;
    private int maxClients;

    public GroupMeet(UUID trainer, Date date, int maxClients) {
        this.clients = new ArrayList<UUID>();
        this.trainer = trainer;
        this.date = date;
        this.maxClients = maxClients;
    }

    public GroupMeet() {
        maxClients = -1;
    }

    public UUID getId() {
        return id;
    }

    public void addClient(UUID client) {
        this.clients.add(client);
    }

    public List<UUID> getClients() {
        return clients;
    }

    public UUID getTrainer() {
        return trainer;
    }

    public Date getDate() {
        return date;
    }
}
