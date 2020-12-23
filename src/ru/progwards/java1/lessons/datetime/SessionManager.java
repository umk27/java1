package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SessionManager {

    public static void main(String[] args) throws InterruptedException {
        UserSession us = new UserSession("1");
        UserSession us2 = new UserSession("2");
        SessionManager sm = new SessionManager(10);
        sm.add(us);
        Thread.sleep((long) 0.6);
        sm.add(us2);
        Thread.sleep((long) 0.5);
        sm.deleteExpired();
        UserSession u = sm.get(us.getSessionHandle());
        UserSession u2 = sm.get(us2.getSessionHandle());
        System.out.println(u.getUserName());
        System.out.println(u2.getUserName());


    }

    private ArrayList<UserSession> sessions = new ArrayList<>();
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
        sessions.add(userSession);
    }

    public UserSession find(String userName) {
        for (int i = 0; i < sessions.size(); i++) {
            UserSession us = sessions.get(i);
            LocalDateTime l = us.getLastAccess();
            Duration d = Duration.between(l, LocalDateTime.now());
            int i1 = (int) d.toSeconds();
            if (us.getUserName().equals(userName) && i1 <= sessionValid) {
                us.updateLastAccess();
                return us;
            }

        }
        return null;
    }

    public UserSession get(int sessionHandle) {
        for (int i = 0; i < sessions.size(); i++) {
            UserSession us = sessions.get(i);
            LocalDateTime l = us.getLastAccess();
            Duration d = Duration.between(l, LocalDateTime.now());
            int i1 = (int) d.toSeconds();
            if (us.getSessionHandle() == sessionHandle && i1 <= sessionValid) {
                us.updateLastAccess();
                return us;
            }

        }
        return null;
    }

    public void delete(int sessionHandle) {
        for (int i = 0; i < sessions.size(); i++) {
            UserSession us = sessions.get(i);
            if (us.getSessionHandle() == sessionHandle) {
                sessions.remove(us);
            }
        }
    }

    public void deleteExpired() {
        for (int i = 0; i < sessions.size(); i++) {
            UserSession us = sessions.get(i);
            LocalDateTime l = us.getLastAccess();
            Duration d = Duration.between(l, LocalDateTime.now());
            int i1 = (int) d.toSeconds();
            if (i1 > sessionValid) {
                sessions.remove(us);
            }

        }
    }
}

