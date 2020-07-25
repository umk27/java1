package ru.progwards.java1.lessons.interfaces;

public class CyclesGoldenFibo {

    public static void main(String[] args) {
        lastFibo.n = 15;
        lastFibo.fibo = 610;
        System.out.println(fiboNumber(14));


        //     for (int x = 1; x <= 100; x++) {
        //         for (int y = 1; y <= 100; y++) {
        //            for (int z = 1; z <= 100; z++) {
        //                boolean c = isGoldenTriangle(x, y, z);
        //                if (c == true) System.out.println("Сторона x= " + x + " Сторона y= " + y + " Сторона z= " + z);
        //            }
        //        }
        //     }
    }

    private static CacheInfo lastFibo;

    public static boolean containsDigit(int number, int digit) {
        char a;
        String a1;
        int a2;
        String number1 = Integer.toString(number);
        for (int i = 0; i != 10; i++) {
            if (i >= number1.length()) break;
            System.out.println(i);
            a = number1.charAt(i);
            a1 = String.valueOf(a);
            System.out.println(a1);
            a2 = Integer.parseInt(a1);
            if (a2 == digit) return true;
        }
        return false;
    }

    public static int fiboNumber(int n) {
        if (n == lastFibo.n) return lastFibo.fibo;
        int a = 1;
        int b = 1;
        if (n == 1 || n == 2) return 1;
        int c = 0;
        for (int i = 2; i != n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        lastFibo.fibo = c;
        return lastFibo.fibo;
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        float a1 = (float) a;
        float b1 = (float) b;
        float c1 = (float) c;
        if (a == b) if (1.61703 < a1 / c1 && a1 / c1 < 1.61903) return true;
        if (a == c) if (1.61703 < a1 / b1 && a1 / b1 < 1.61903) return true;
        if (b == c) if (1.61703 < b1 / a1 && b1 / a1 < 1.61903) return true;
        return false;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;
    }
}
