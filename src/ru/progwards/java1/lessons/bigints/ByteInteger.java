package ru.progwards.java1.lessons.bigints;

public class ByteInteger implements Add<Byte> {

    byte num;

    public ByteInteger(byte num) {
        this.num = num;
    }

    @Override
    public int toInt() {
        return 0;
    }
}
