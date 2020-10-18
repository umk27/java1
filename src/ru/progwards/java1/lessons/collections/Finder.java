package ru.progwards.java1.lessons.collections;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {

    public static void main(String[] args) {
        Collection<Integer> numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        //   System.out.println(findSequence(numbers));
        Collection<String> names = new ArrayList();
        names.add("Григорий");
        names.add("Борис");
        names.add("Александр");
        names.add("Василий");
        names.add("Григорий");
        names.add("Борис");
        System.out.println(findSimilar(names));

    }

    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        ArrayList<Integer> numbers1 = (ArrayList<Integer>) numbers;
        Collection<Integer> collection = new ArrayList();
        int a = numbers1.get(0) + numbers1.get(1);
        int i1 = 0;
        int i2 = 1;
        for (int i = 2; i < numbers1.size() - 1; i++) {
            int b = numbers1.get(i) + numbers1.get(i + 1);
            if (b < a) {
                a = b;
                i1 = i;
                i2 = i + 1;
            }
        }
        collection.add(i1);
        collection.add(i2);
        return collection;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        ArrayList<Integer> numbers1 = (ArrayList<Integer>) numbers;
        Collection<Integer> collection = new ArrayList();
        for (int i = 1; i < numbers1.size() - 1; i++) {
            if (numbers1.get(i) > numbers1.get(i - 1) && numbers1.get(i) > numbers1.get(i + 1)) {
                collection.add(numbers1.get(i));
            }
        }
        return collection;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        boolean b = false;
        ArrayList<Integer> numbers1 = (ArrayList<Integer>) numbers;
        Collection<Integer> collection = new ArrayList();
        for (int i = 1; i < numbers1.size(); i++) {
            for (int j = 0; j < numbers1.size(); j++) {
                if (numbers1.get(j) == i) {
                    b = true;
                }
            }
            if (!b) {
                return false;
            }
            b = false;
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        String s = "";
        int a = 1;
        int b = 0;
        int w = 0;
        ArrayList<String> names1 = (ArrayList<String>) names;
        ArrayList<String> names2 = new ArrayList();
        ArrayList<Integer> z = new ArrayList();
        for (int i = 0; i < names1.size() - 1; i++) {
            for (int j = i + 1; j < names1.size(); j++) {
                if (names1.get(i).equals(names1.get(j))) {
                    a = a + 1;
                }
            }
            s = names1.get(i);
            z.add(a);
            s = s + ":" + a;
            names2.add(s);
            a = 1;
            s = "";
        }
        w = z.get(0);
        for (int i = 1; i < z.size() - 1; i++) {
            if (z.get(i) > w) {
                b = i;
                w = z.get(i);
            }
        }
        return names2.get(b);
    }
}
