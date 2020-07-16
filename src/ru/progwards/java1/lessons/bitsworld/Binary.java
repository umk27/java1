package ru.progwards.java1.lessons.bitsworld;

public class Binary {

    public static void main(String[] args) {
        Binary binary = new Binary((byte) -127);
        System.out.println(binary.toString());
    }

    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i <= 8; i++) {
            s += Integer.toString(num & 1);
            num >>= (byte) 1;
        }
        return s;
    }
}
