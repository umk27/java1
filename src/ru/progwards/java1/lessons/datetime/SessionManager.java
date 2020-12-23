package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SessionManager {

    public static void main(String[] args) {
        UserSession us = new UserSession("1");
        SessionManager sm = new SessionManager(1000);
        sm.add(us);
        sm.find("1");
        sm.get(us.getSessionHandle());

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
            long h = l.getHour();
            long m = l.getMinute();
            long s = l.getSecond();
            long s1 = (h * 3600) + (m * 60) + s;
            Duration d = Duration.between(l, LocalDateTime.now());
            int i1 = (int) d.toSeconds();
            if (us.getUserName().equals(userName) && i1 < sessionValid) {
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
            long h = l.getHour();
            long m = l.getMinute();
            long s = l.getSecond();
            long s1 = (h * 3600) + (m * 60) + s;
            Duration d = Duration.between(l, LocalDateTime.now());
            int i1 = (int) d.toSeconds();
            if (us.getSessionHandle() == sessionHandle && i1 < sessionValid) {
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
            long h = l.getHour();
            long m = l.getMinute();
            long s = l.getSecond();
            long s1 = (h * 3600) + (m * 60) + s;
            Duration d = Duration.between(l, LocalDateTime.now());
            int i1 = (int) d.toSeconds();
            if (i1 < sessionValid) {
                sessions.remove(us);
            }

        }
    }
}

