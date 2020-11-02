package com.example.demo.model;

import java.util.Date;
import java.util.UUID;


public final class CleanerTime {
    private UUID id;
    private UUID cleaner;
    private Date date;

    public CleanerTime(UUID cleaner, Date date) {
        this.cleaner = cleaner;
        this.date = date;
    }

    public CleanerTime() {
    }

    public UUID getId() {
        return id;
    }

    public UUID getCleaner() {
        return cleaner;
    }

    public Date getDate() {
        return date;
    }

}
