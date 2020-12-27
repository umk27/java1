package ru.progwards.java1.lessons.datetime;


import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Profiler {

    public static void main(String[] args) {
        enterSection("Process1");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        enterSection("Process2");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        exitSection("Process2");
        enterSection("Process2");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        exitSection("Process2");
        exitSection("Process1");
        String info = "";
        for (StatisticInfo si : getStatisticInfo()) {
            info += si.sectionName + " " + (si.fullTime / 100 * 100) + " " + (si.selfTime / 100 * 100) + " " + si.count + "\n";
        }
        System.out.println(info);

    }

    static ArrayList<String> names = new ArrayList<>();
    static HashMap<String, ArrayList<Instant>> enter = new HashMap<>();
    static HashMap<String, ArrayList<Instant>> exit = new HashMap<>();

    public static void enterSection(String name) {
        Instant i = Instant.now();
        if (enter.containsKey(name)) {
            ArrayList<Instant> a = enter.get(name);
            a.add(i);
            enter.put(name, a);
        } else {
            names.add(name);
            ArrayList<Instant> a = new ArrayList<>();
            a.add(i);
            enter.put(name, a);
        }
    }

    public static void exitSection(String name) {
        Instant i = Instant.now();
        if (exit.containsKey(name)) {
            ArrayList<Instant> a = exit.get(name);
            a.add(i);
            exit.put(name, a);
        } else {
            ArrayList<Instant> a = new ArrayList<>();
            a.add(i);
            exit.put(name, a);
        }
    }

    public static List<StatisticInfo> getStatisticInfo() {
        List<StatisticInfo> list = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            StatisticInfo statisticInfo = new StatisticInfo();
            statisticInfo.sectionName = names.get(i);
            ArrayList<Instant> i1 = enter.get(names.get(i));
            ArrayList<Instant> i2 = exit.get(names.get(i));
            statisticInfo.count = i1.size();
            statisticInfo.fullTime = 0;
            for (int j = 0; j < i1.size(); j++) {
                long a = Duration.between(i1.get(j), i2.get(j)).toMillis();
                statisticInfo.fullTime = (int) (statisticInfo.fullTime + a);
                statisticInfo.selfTime = statisticInfo.fullTime;
                for (int v = i + 1; v < names.size(); v++) {
                    ArrayList<Instant> i11 = enter.get(names.get(v));
                    ArrayList<Instant> i22 = exit.get(names.get(v));
                    for (int x = 0; x < i11.size(); x++) {
                      //  long q1 = i1.get(j).toEpochMilli();
                      //  long q11 = i11.get(x).toEpochMilli();
                      //  long w1 = i22.get(x).toEpochMilli();
                      //  long w11 = i2.get(j).toEpochMilli();
                        if (i1.get(j).toEpochMilli() <= i11.get(x).toEpochMilli() && i22.get(x).toEpochMilli() <= i2.get(j).toEpochMilli()) {
                            long b = Duration.between(i11.get(x), i22.get(x)).toMillis();
                            statisticInfo.selfTime = (int) (statisticInfo.selfTime - b);
                        }
                    }
                }
            }

            list.add(statisticInfo);
        }
        return list;
    }
}
