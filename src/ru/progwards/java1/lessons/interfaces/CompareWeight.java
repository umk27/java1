package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight<ArraySort> {
    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    public CompareResult compareWeight(ArraySort smthHasWeigt);

}
