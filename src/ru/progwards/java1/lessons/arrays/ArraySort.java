package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        ArraySort arraySort = new ArraySort();
        int[] a = {4, 10, 1, 7, 9, 5, 3, 8};
        arraySort.sort(a);

    }

    public static void sort(int[] a) {
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
