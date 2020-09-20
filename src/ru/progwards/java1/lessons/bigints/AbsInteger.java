package ru.progwards.java1.lessons.bigints;

public class AbsInteger implements Add<AbsInteger> {

    static public AbsInteger add(AbsInteger num1, AbsInteger num2) {
        Integer z = num1.toInt() + num2.toInt();
        z.toString();
        Object z1 = (Object)z;
        return (AbsInteger) z1;
    }


    @Override
    public int toInt() {
        String s = String.valueOf(this);
        return Integer.getInteger(s);
    }

    public String toString() {
        return String.valueOf(this);
    }

}
