package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

public class UserSession {

    public static void main(String[] args) {
        UserSession us = new UserSession("qwerty");
    }

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
        lastAccess = LocalDateTime.now();
    }

    public UserSession(String userName) {
        this.userName = userName;
        Random rand = new Random();
        this.sessionHandle = rand.nextInt(100);
        this.lastAccess = LocalDateTime.now();
    }
}
