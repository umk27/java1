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
        int i = 0;
        String s = "";
        byte num1 = 0;
        if (num >= 0) {
            num1 = num;
        } else {
            num1 = (byte) (128 + num);
        }
        System.out.println(num1);
        while (num1 != 0) {
            s = Integer.toString(num1 % 2) + s;
            System.out.println(s);
            num1 = (byte) (num1 / (byte) 2);
            System.out.println(num1);
            i++;
            System.out.println(i);
        }

        if (num >= 0) {

            switch (i) {
                case 7:
                    s = "0" + s;
                    break;
                case 6:
                    s = "00" + s;
                    break;
                case 5:
                    s = "000" + s;
                    break;
                case 4:
                    s = "0000" + s;
                    break;
                case 3:
                    s = "00000" + s;
                    break;
                case 2:
                    s = "000000" + s;
                    break;
                case 1:
                    s = "0000000" + s;
                    break;
                case 0:
                    s = "00000000";
            }
        }

        else {

            switch (i) {
                case 7:
                    s = "1" + s;
                    break;
                case 6:
                    s = "10" + s;
                    break;
                case 5:
                    s = "100" + s;
                    break;
                case 4:
                    s = "1000" + s;
                    break;
                case 3:
                    s = "10000" + s;
                    break;
                case 2:
                    s = "100000" + s;
                    break;
                case 1:
                    s = "1000000" + s;
                    break;
                case 0:
                    s = "10000000";
            }
        }

        return s;
    }
}
