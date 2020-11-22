package ru.progwards.java1.lessons.datetime;


import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Profiler {

    public static void main(String[] args) {
        enterSection("Process1");
        // exitSection("Process1");
        //  enterSection("Process1");
        exitSection("Process1");
        List<StatisticInfo> l = getStatisticInfo();
        System.out.println(l);
        System.out.println(l.get(0).count);
        System.out.println(l.get(0).fullTime);
        System.out.println(l.get(0).selfTime);
        System.out.println(l.get(0).sectionName);

    }

    static ArrayList<String> names = new ArrayList<>();
    static HashMap<String, ArrayList<Instant>> enter = new HashMap<>();
    static HashMap<String, ArrayList<Instant>> exit = new HashMap<>();

    public static void enterSection(String name) {
        Instant i = Instant.now();
        names.add(name);
        if (enter.containsKey(name)) {
            ArrayList<Instant> a = enter.get(name);
            a.add(i);
            enter.put(name, a);
        } else {
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
            statisticInfo.count = i1.size() - 1;
            statisticInfo.fullTime = 0;
            for (int j = 0; j < i1.size(); j++) {
                long a = Duration.between(i1.get(j), i2.get(j)).toMillis();
                statisticInfo.fullTime = (int) (statisticInfo.count + a);
                statisticInfo.selfTime = statisticInfo.fullTime;
                for (int v = 0; v < names.size(); v++) {
                    ArrayList<Instant> i11 = enter.get(names.get(v));
                    ArrayList<Instant> i22 = exit.get(names.get(v));
                    for (int x = 0; x < i11.size(); x++) {
                        if (i1.get(j).toEpochMilli() < i11.get(x).toEpochMilli() && i22.get(x).toEpochMilli() < i2.get(j).toEpochMilli()) {
                            long b = Duration.between(i11.get(j), i22.get(j)).toMillis();
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
