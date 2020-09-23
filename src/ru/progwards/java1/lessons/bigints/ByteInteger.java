package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {

    public static void main(String[] args) {
        AbsInteger b1 = new ByteInteger((byte) 5);
        AbsInteger b2 = new ByteInteger((byte) 3);
        ByteInteger b3 = (ByteInteger) add(b1, b2);
        System.out.println(b3.num);
    }

    byte num;

    public ByteInteger(byte num) {
        this.num = num;
    }

    @Override
    public int toInt() {
        return num;
    }
}
