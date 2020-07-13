package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b0101011));

    }

    public static int sumBits(byte value) {
        int a = 0;
        for (int i = 0; value != 0; i++) {
            a += value & 1;
            value >>= (byte) 1;
            if (i > 8) {
                break;
            }
            System.out.println(i);
        }
        return a;
    }
}