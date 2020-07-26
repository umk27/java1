package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public interface CompareWeight<CompareWeight> {
    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public static void sort(CompareWeight[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight<CompareWeight>(a[j])==CompareResult.GREATER) {
                    CompareWeigh b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
