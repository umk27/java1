package ru.progwards.java1.lessons.maps;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {

    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(salesInfo.loadOrders("W2.txt"));
        HashMap<String, AbstractMap.SimpleEntry<Double, Integer>> m = (HashMap<String, AbstractMap.SimpleEntry<Double, Integer>>) salesInfo.getCustomers();
        System.out.println(m);
        //System.out.println(salesInfo.getGoods());


    }

    static HashMap<Integer, String[]> map = new HashMap<>();

    public int loadOrders(String fileName) {
        int n = 0;
        try (FileReader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();
                String[] s = a.split(",");
                for (int i = 0; i < s.length; i++) {
                    s[i] = s[i].trim();
                }
                Integer i = Integer.valueOf(s[2]);
                Double d = Double.valueOf(s[3]);
                if (s.length == 4 && i != null && d != null) {
                    n = n + 1;
                    map.put(n, s);
                }
            }
        } catch (IOException E) {

        }
        return n;
    }

    public Map<String, Double> getGoods() {
        LinkedHashMap<String, Double> result = new LinkedHashMap<>();
        double a = 0;
        for (int i = 1; i <= map.size(); i++) {
            String[] s = map.get(i);
            a = Double.valueOf(s[3]);
            for (int j = 1; j <= map.size(); j++) {
                String[] z = map.get(j);
                if (s[1].equals(z[1])) {
                    a = a + Double.valueOf(z[3]);
                }
            }
            if (!result.containsKey(s[1])) {
                result.put(s[1], a);
            }
        }
        return result;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        double a = 0;
        int b = 0;
        String w = "";
        char x;
        LinkedHashMap<String, AbstractMap.SimpleEntry<Double, Integer>> result = new LinkedHashMap<>();
        List<String> list = new ArrayList();
        HashMap<Integer, String[]> map1 = new HashMap<>();
        map1.putAll(map);
        Collections.copy((List)map1, (List)map);
        HashMap<String, String> map2 = new HashMap<>();
        for (int i = 1; i <= map1.size(); i++) {
            String[] s1 = map1.get(i);
            w = s1[0];
            char[] c1 = s1[0].toCharArray();
            x = c1[0];
            for (int j = 2; j <= map1.size(); j++) {
                String[] s2 = map1.get(j);
                char[] c2 = s2[0].toCharArray();
                if ((int) c2[0] < (int) x) {
                    w = s2[0];
                    x = c2[0];
                    map1.put(i, s2);
                    map1.put(j, s1);
                }

            }
            if (!list.contains(w)) {
                list.add(w);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j <= map.size(); j++) {
                String[] s1 = map.get(i);
                if (s1[0].equals(list.get(i))) {
                    a = a + Double.valueOf(s1[3]);
                    b = b + Integer.valueOf(s1[2]);

                }

            }
            a = 0;
            b = 0;
            result.put(list.get(i), new AbstractMap.SimpleEntry<>(a, b));
        }

        return result;
    }

}
