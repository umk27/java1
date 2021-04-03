package ru.progwards.java1.lessons.bigints;


import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    public static void main(String[] args) {

        ArrayInteger arrayInteger1 = new ArrayInteger(2);
        arrayInteger1.fromInt(BigInteger.valueOf(12));
        ArrayInteger arrayInteger2 = new ArrayInteger(3);
        arrayInteger2.fromInt(BigInteger.valueOf(124));
        System.out.println(arrayInteger1.add(arrayInteger2));
    }


    byte[] digits;

    ArrayInteger(int n) {
        this.digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        BigInteger value1 = new BigInteger(String.valueOf(value));
        int s = 0;
        for (int i = 1; value1 != BigInteger.ZERO; i++) {
            value1 = value1.divide(BigInteger.TEN);
            s = +i;
        }
        String z = "";
        digits = new byte[s];
        for (int i = 0; i < digits.length; i++) {
            BigInteger rem = value.remainder(BigInteger.TEN);
            z = String.valueOf(rem);
            value = value.divide(BigInteger.TEN);
            digits[digits.length - 1 - i] = Byte.valueOf(z);
        }
        System.out.println(Arrays.toString(digits));
    }

    BigInteger toInt() {
        BigInteger s = BigInteger.ZERO;
        for (int i = 0; i < digits.length; i++) {
            BigInteger q = new BigInteger(String.valueOf((int) digits[i]));
            s = (s.multiply(BigInteger.TEN)).add(q);
        }
        return s;
    }

    boolean add(ArrayInteger num) {
        int a;
        int b;
        if (digits[0] + num.digits[0] > 10) return false;
        if (digits[0] + num.digits[0] == 9 && digits[1] + num.digits[1] > 10) return false;
        byte[] digits1;
        digits1 = Arrays.copyOf(digits, digits.length);
        if (digits.length >= num.digits.length) {
            for (int i = digits.length - 1; i > digits.length - num.digits.length - 1; i--) {
                System.out.println(i);
                a = digits1[i] + num.digits[i - (digits.length - num.digits.length)];
                System.out.println(a);
                if (a < 10) {
                    digits1[i] = (byte) a;
                } else {
                    a -= 10;
                    digits1[i] = (byte) a;
                    b = digits1[i - 1] + 1;
                    System.out.println(b);
                    digits1[i - 1] = (byte) b;
                }
            }

        } else {
            for (byte i : digits) {
                i = 0;
            }
            return false;
        }
        if (digits1.length > digits.length) {
            for (byte i : digits) {
                i = 0;
            }
            return false;
        }
        digits = Arrays.copyOf(digits1, digits1.length);

        System.out.println(Arrays.toString(digits));
        return true;
    }
}