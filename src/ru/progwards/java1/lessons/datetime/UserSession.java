package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

public class UserSession {

    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;

    public int getSessionHandle() {
        return sessionHandle;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public String getUserName() {
        return userName;
    }

    public void updateLastAccess() {
        lastAccess = LocalDateTime.from(Instant.now());
    }

    public UserSession(String userName) {
        Random rand = new Random();
        this.sessionHandle = rand.nextInt(100);
        this.lastAccess = LocalDateTime.from(Instant.now());
    }
}
