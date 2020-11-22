package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsageFrequency {

    public static void main(String[] args) {
        UsageFrequency usageFrequency = new UsageFrequency();
        usageFrequency.processFile("wiki.test.tokens");
        System.out.println(usageFrequency.getLetters());
        System.out.println(usageFrequency.getWords());
    }

    String s;

    public void processFile(String fileName) {
        s = "";
        try (FileReader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                s = s + " " + scanner.nextLine();
            }
        } catch (IOException E) {

        }

    }

    public Map<Character, Integer> getLetters() {
        Map<Character, Integer> map = new HashMap();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (Character.isAlphabetic(c[i]) || Character.isDigit(c[i])) {
                if (map.containsKey(c[i])) {
                    int a = map.get(c[i]) + 1;
                    map.put(c[i], a);
                } else {
                    map.put(c[i], 1);
                }
            }
        }
        return map;
    }

    public Map<String, Integer> getWords() {
        Map<String, Integer> map = new HashMap();
        String w = "";
        String[] z = s.split(" ");
        for (int i = 0; i < z.length; i++) {
            char[] c = z[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (Character.isAlphabetic(c[j]) || Character.isDigit(c[j])) {
                    w = w + c[j];
                }
            }

            z[i] = w;
            w = "";
        }
        for (int i = 0; i < z.length; i++) {
            if (map.containsKey(z[i])) {
                int a = map.get(z[i]) + 1;
                map.put(z[i], a);
            } else {
                map.put(z[i], 1);
            }
        }
        map.remove("");
        return map;
    }
}
