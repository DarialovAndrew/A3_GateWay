package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public final class TrainerMeet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
