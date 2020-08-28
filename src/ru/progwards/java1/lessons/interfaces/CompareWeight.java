package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public interface CompareWeight<CompareWeight> {


    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    public void sort(CompareWeight[] a);

}