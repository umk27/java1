package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight<CompareWeight> {
    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt);

}
