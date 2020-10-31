package ru.progwards.java1.lessons.sets;

import org.w3c.dom.ls.LSOutput;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class LettersInFile {

    public static void main(String[] args) {
        System.out.println(process("t10.txt"));

    }

    public static String process(String fileName) {
        ArrayList<Character> s = new ArrayList<>();
        ArrayList<Character> z = new ArrayList<>();
        ArrayList<Character> x = new ArrayList<>();
        ArrayList<Character> v = new ArrayList<>();
        String s1 = "";
        String z1 = "";
        String x1 = "";
        String v1 = "";
        HashSet<Character> abc = new HashSet<>();
        HashSet<Character> ABC = new HashSet<>();
        HashSet<Character> абв = new HashSet<>();
        HashSet<Character> АБВ = new HashSet<>();
        ArrayList<Character> r = new ArrayList<>();

        for (int i = 97; i < 123; i++) {
            abc.add((char) i);
            ABC.add(Character.toUpperCase((char) i));
        }

        for (int i = 1072; i < 1104; i++) {
            абв.add((char) i);
            АБВ.add(Character.toUpperCase((char) i));
        }

        try (FileReader reader = new FileReader(fileName)) {
            ;
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                char[] c = scanner.nextLine().toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if (ABC.contains(c[i]) || abc.contains(c[i]) || АБВ.contains(c[i]) || абв.contains(c[i])) {
                        r.add(c[i]);
                    }
                }

            }
        } catch (Exception e) {
            e.getMessage();
        }

        for (int i = 0; i < r.size(); i++) {
            if (ABC.contains(r.get(i))) {
                s.add(r.get(i));
            } else if (abc.contains(r.get(i))) {
                z.add(r.get(i));
            } else if (АБВ.contains(r.get(i))) {
                x.add(r.get(i));
            } else if (абв.contains(r.get(i))) {
                v.add(r.get(i));
            }

        }

        while (s.size() != 0) {
            char a = s.get(0);
            for (int i = 0; i < s.size(); i++) {
                if ((int) s.get(i) < (int) a) {
                    a = s.get(i);

                }
            }
            s.remove(s.indexOf(a));
            s1 = s1 + a;


        }

        while (z.size() != 0) {
            char a = z.get(0);
            for (int i = 0; i < z.size(); i++) {
                if ((int) z.get(i) < (int) a) {
                    a = z.get(i);


                }
            }
            z.remove(z.indexOf(a));
            z1 = z1 + a;


        }

        while (x.size() != 0) {
            char a = x.get(0);
            for (int i = 0; i < x.size(); i++) {
                if ((int) x.get(i) < (int) a) {
                    a = x.get(i);


                }
            }
            x.remove(x.indexOf(a));
            x1 = x1 + a;


        }

        while (v.size() != 0) {
            char a = v.get(0);
            for (int i = 0; i < v.size(); i++) {
                if ((int) v.get(i) < (int) a) {
                    a = v.get(i);


                }
            }
            v.remove(v.indexOf(a));
            v1 = v1 + a;


        }
        return s1 + z1 + x1 + v1;
    }
}