package com.example.database;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private String name;
    private String lastName;
    private UUID uuid;

    public User() {
        this.name = name;
        this.lastName = lastName;
        this.uuid = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUuid() {
        return uuid;
    }
}
