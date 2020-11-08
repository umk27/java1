package ru.progwards.java1.lessons.queues;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class CollectionsSort {

    private static Collection<Integer> data;

    public static void main(String[] args) {
        data = new ArrayList<>();
        Collections.addAll(data, 5, 7, 9, 3, 4, 2, 8);
        System.out.println(compareSort());

    }

    public static void mySort(Collection<Integer> data) {
        ArrayList<Integer> data1 = (ArrayList<Integer>) data;
        int b = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data1.get(i) > data1.get(j)) {
                    b = data1.get(i);
                    data1.add(i, data1.get(j));
                    data1.remove(i + 1);
                    data1.add(j, b);
                    data1.remove(j + 1);
                }
            }
        }

    }

    public static void minSort(Collection<Integer> data) {
        Collection<Integer> data1 = new ArrayList<>(data.size());
        int s = data.size();
        for (int i = 0; i < s; i++) {
            int a = Collections.min(data);
            data.remove(a);
            data.add(2147483647);
            data1.add(a);
        }
        Collections.copy((ArrayList<Integer>) data, (ArrayList<Integer>) data1);

    }

    static void collSort(Collection<Integer> data) {
        Collections.sort((ArrayList<Integer>) data);

    }

    public static Collection<String> compareSort() {
        long start = System.nanoTime();
        collSort(data);
        long a1 = System.nanoTime() - start;
        System.out.println(a1);
        start = System.nanoTime();
        minSort(data);
        long a2 = System.nanoTime() - start;
        System.out.println(a2);
        start = System.nanoTime();
        mySort(data);
        long a3 = System.nanoTime() - start;
        System.out.println(a3);
        Collection<String> result = new ArrayList<>();

        if (a3 < a2 && a3 < a1) {
            result.add("collSort");
            if (a2 < a1) {
                result.add("minSort");
                result.add("mysort");
            } else {
                result.add("mysort");
                result.add("minSort");
            }
        }

        if (a2 < a3 && a2 < a1) {
            result.add("minSort");
            if (a3 < a1) {
                result.add("collSort");
                result.add("mysort");
            } else {
                result.add("mysort");
                result.add("collSort");
            }
        }

        if (a1 < a2 && a1 < a3) {
            result.add("mySort");
            if (a2 < a1) {
                result.add("minSort");
                result.add("collsort");
            } else {
                result.add("collSort");
                result.add("minSort");
            }
        }

        return result;
    }
}
