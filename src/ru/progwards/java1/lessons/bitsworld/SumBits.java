package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b0101011));

    }

    public static int sumBits(byte value) {
        int a =0;
        while (value != 0) {
            a += value & 1;
            value >>=  (byte) 1;
        }
        return a;
    }
}
