package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SessionManager {

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
            if (us.getUserName().equals(userName) && s1 < sessionValid) {
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
            if (us.getSessionHandle() == sessionHandle && s1 < sessionValid) {
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
            if (s1 < sessionValid) {
                sessions.remove(us);
            }

        }
    }
}

