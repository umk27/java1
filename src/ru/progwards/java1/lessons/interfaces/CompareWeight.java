package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public interface CompareWeight<CompareWeight> {


    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public static void sort(int[] a) {           //Как сделать обобщение принимаемых параметров у статического метода интерфейса?
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

}