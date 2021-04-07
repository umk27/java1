package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public interface CompareWeight<CompareWeight> {

    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    //public static void sort(CompareWeight[] a);

}