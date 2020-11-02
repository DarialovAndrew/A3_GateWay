package com.example.demo.model;

import java.util.Date;
import java.util.UUID;


public final class TrainerMeet {

    private UUID id;
    private UUID trainer;
    private UUID client;
    private Date date;

    public TrainerMeet(UUID trainer, UUID client, Date date) {
        this.trainer = trainer;
        this.client = client;
        this.date = date;
    }

    public TrainerMeet() {
    }

    public UUID getId() {
        return id;
    }

    public UUID getTrainer() {
        return trainer;
    }

    public UUID getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }
}
