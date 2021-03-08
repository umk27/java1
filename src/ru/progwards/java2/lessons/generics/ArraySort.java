package ru.progwards.java2.lessons.generics;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        String[] c = {"c", "a", "b"};
        Integer[] a = {4, 10, 1, 7, 9, 5, 3, 8};
        sort(c);
    }


    public static <T extends Comparable> void sort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {

                if (a[i].compareTo(a[j]) > 0) {
                    T b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
