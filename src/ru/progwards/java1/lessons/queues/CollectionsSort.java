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
        Integer[] a = new Integer[data.size()];
        data.toArray(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        data = new ArrayList<>(Arrays.asList(a));
       
    }

    public static void minSort(Collection<Integer> data) {
        Collection<Integer> data1 = new ArrayList<>(data.size());
        int s = data.size();
        while (!data.isEmpty()) {
            int a = Collections.min(data);
            data.remove(a);
            data1.add(a);
        }
        data.addAll(data1);

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
