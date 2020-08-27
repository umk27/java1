package ru.progwards.java1.lessons.interfaces;

public class ArraySort implements CompareWeight<Integer[]> {

    public static void main(String[] args) {
        int[] a = {4, 10, 1, 7, 9, 5, 3, 8};
        CompareWeight.sort(a);

    }

    @Override
    public CompareResult compareWeight(Integer[] smthHasWeigt) {
        return null;
    }


}
