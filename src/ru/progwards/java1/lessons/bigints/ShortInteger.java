package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger{

    short num;

    public ShortInteger(short num) {
        this.num = num;
    }

    @Override
    public int toInt() {
        return num;
    }


}
