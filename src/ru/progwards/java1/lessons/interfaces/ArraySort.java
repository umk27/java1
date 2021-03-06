package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort implements CompareWeight<CompareWeight> {

    public static void main(String[] args) {

    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        return null;
    }

    public static void sort(CompareWeight[] a) {                         //С интерфейсом CompareWeight он не связан,
        for (int i = 0; i < a.length; i++) {                             //т.к. статический метод должен быть описан в самом интерфейсе
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    CompareWeight b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}



