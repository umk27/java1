package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    public static void main(String[] args) {
      //  BigAlgebra bigAlgebra = new BigAlgebra();
      //  BigDecimal num = new BigDecimal(2);
      //  BigInteger num1 = new BigInteger(String.valueOf(4));
     //   System.out.println(bigAlgebra.fastPow(num, 7));
     //   System.out.println(bigAlgebra.fibonacci(6));


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
        int a = 1;
        int b = 1;
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        int c = 0;
        for (int i = 2; i != n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return new BigInteger(String.valueOf(c));
    }
}