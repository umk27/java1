package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {

    public static void main(String[] args) {
        System.out.println(checkBit((byte) 0b010001, 4));
    }

    public static int checkBit(byte value, int bitNumber) {
        value >>= (byte) bitNumber;
        return value & 1;
    }
}
