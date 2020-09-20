package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    public static void main(String[] args) {
        System.out.println(fibonacci(48));


    }


  static  BigDecimal fastPow(BigDecimal num, int pow) {
        byte a;
        BigDecimal s = new BigDecimal(1);
        BigDecimal z = num;
        for (int i = 0; i < 8; i++) {
            if (pow == 0) break;
            a = (byte) ((byte) pow & 1);
            if (i != 0) z = z.multiply(z);
            if (a == 1) {
                s = s.multiply(z);
            }
            pow >>= (byte) 1;
        }
        return s;

    }

  static BigInteger fibonacci(int n) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        BigInteger c =new BigInteger("1");
        for (int i = 2; i != n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }
}