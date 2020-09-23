package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {

    int num;

    public IntInteger(int num) {
        this.num = num;
    }

    @Override
    public int toInt() {
        return num;
    }
}
