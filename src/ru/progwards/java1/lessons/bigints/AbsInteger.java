package ru.progwards.java1.lessons.bigints;

public class AbsInteger {


    static public AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int z = num1.toInt() + num2.toInt();
        if (-128 < z && z < 127) {
            AbsInteger ab = new ByteInteger((byte) z);
            return ab;
        } else if (-32768 < z && z < 32767) {
            AbsInteger as = new ShortInteger((short) z);
            return as;
        } else {
            AbsInteger ai = new IntInteger(z);
            return ai;
        }
    }

    public int toInt() {
        return 0;
    }

    @Override
    public String toString() {
        return "AbsInteger{}";
    }
}
