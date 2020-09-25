package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class AbsInteger {


    static public AbsInteger add(AbsInteger num1, AbsInteger num2) {
        BigInteger a = new BigInteger(String.valueOf(num1.toInt()));
        BigInteger b = new BigInteger(String.valueOf(num2.toInt()));
        BigInteger z = a.add(b);
        String z1 = String.valueOf(z);
        int z2 = Integer.parseInt(z1);
        if (-128 < z2 && z2 < 127) {
            AbsInteger ab = new ByteInteger((byte) z2);
            return ab;
        } else if (-32768 < z2 && z2 < 32767) {
            AbsInteger as = new ShortInteger((short) z2);
            return as;
        } else {
            AbsInteger ai = new IntInteger(z2);
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
