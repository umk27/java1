package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort implements CompareWeight<Integer> {

    public static void main(String[] args) {
        int[] a = {4, 10, 1, 7, 9, 5, 3, 8};

    }

    @Override
    public CompareResult compareWeight(Integer smthHasWeigt) {
        return null;
    }

    @Override
    public void sort(Integer[] a) {
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



