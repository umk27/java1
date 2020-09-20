package ru.progwards.java1.lessons.bigints;

public class ShortInteger implements Add<Short> {

    public static void main(String[] args) {
        System.out.println(AbsInteger.add(100, 100));

    }

    short num;

    public ShortInteger(short num) {
        this.num = num;
    }

    @Override
    public int toInt() {
        return 0;
    }


}
