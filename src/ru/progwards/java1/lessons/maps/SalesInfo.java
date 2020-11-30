package ru.progwards.java1.lessons.maps;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {

    public static void main(String[] args) {
          SalesInfo salesInfo = new SalesInfo();
          System.out.println(salesInfo.loadOrders("W2.txt"));
        //  HashMap<String, AbstractMap.SimpleEntry<Double, Integer>> m = (HashMap<String, AbstractMap.SimpleEntry<Double, Integer>>) salesInfo.getCustomers();
        // System.out.println(m);
        //System.out.println(salesInfo.getGoods());


    }

    static HashMap<Integer, String[]> map = new HashMap<>();

    public int loadOrders(String fileName) {
        Integer i1 = null;
        Double d = null;
        boolean b1 = true;
        boolean b2 = true;
        int n = 0;
        try (FileReader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();
                String[] s = a.split(",");
                for (int i = 0; i < s.length; i++) {
                    s[i] = s[i].trim();
                }
                char[] c = s[2].toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if (!Character.isDigit(c[i])) {
                        b1 = false;
                    }
                }
                if (b1) {
                    i1 = Integer.valueOf(s[2]);
                }
                String z = s[3];
                z.replace(".", "");
                char[] q = z.toCharArray();
                for (int i = 0; i < q.length; i++) {
                    if (!Character.isDigit(q[i])) {
                        b2 = false;
                    }
                }
                if (b2) {
                    d = Double.valueOf(s[3]);
                }
                if (s.length == 4 && i1 != null && d != null) {
                    n = n + 1;
                    map.put(n, s);
                }
                i1 = null;
                d = null;
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
        int v = 0;
        int a = 0;
        double b = 0;
        String z1[];
        char g;
        int x = 0;
        LinkedHashMap<String, AbstractMap.SimpleEntry<Double, Integer>> result = new LinkedHashMap<>();
        HashMap<Integer, String[]> map2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= map.size(); i++) {
            String[] s = map.get(i);
            a = Integer.valueOf(s[2]);
            b = Double.valueOf(s[3]);
            for (int j = i + 1; j <= map.size(); j++) {
                String[] z = map.get(j);
                if (s[0].equals(z[0])) {
                    a = a + Integer.valueOf(z[2]);
                    b = b + Double.valueOf(z[3]);
                }

            }
            String[] q = new String[3];
            q[0] = String.valueOf(s[0]);
            q[1] = String.valueOf(b);
            q[2] = String.valueOf(a);

            if (!set.contains(s[0])) {
                x++;
                map2.put(x, q);
            }
            set.add(s[0]);
        }

        for (int i = 1; i <= map2.size(); i++) {
            v = 0;
            int i1 = i;
            String[] z = new String[3];
            String[] s = map2.get(i);
            z1 = s;
            char[] c = s[0].toCharArray();
            g = c[0];
            for (int j = i + 1; j <= map2.size(); j++) {
                z = map2.get(j);
                char[] w = z[0].toCharArray();
                if ((int) w[0] < g) {
                    g = w[0];
                    v = j;
                    z1 = z;
                }

            }
            if (v != 0) {
                map2.put(i, z1);
                map2.put(v, s);
            }
            double r = Double.valueOf(z1[1]);
            int t = Integer.valueOf(z1[2]);
            result.put(z1[0], new AbstractMap.SimpleEntry<Double, Integer>(r, t));
        }

        return result;
    }

}
