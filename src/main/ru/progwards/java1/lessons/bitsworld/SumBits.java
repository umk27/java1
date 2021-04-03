package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b10000000));

    }

    public static int sumBits(byte value) {
        int a = 0;
        for (int i = 1; i <= 8; i++) {
            a += value & 1;
            value >>= (byte) 1;
        }
        return a;
    }
}


