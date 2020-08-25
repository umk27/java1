package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    public static void main(String[] args) {
        lastFibo = new CalculateFibonacci.CacheInfo();
        lastFibo.fibo = 5;
        lastFibo.n = 5;
        System.out.println(fiboNumber(1));
        System.out.println(getLastFibo().fibo);
        System.out.println(getLastFibo().n);
        clearLastFibo();
        System.out.println(fiboNumber(15));

    }

    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {
        if (lastFibo != null && n == lastFibo.n) return lastFibo.fibo;
        int a = 1;
        int b = 1;
        if (n == 1 || n == 2) {
            lastFibo = new CalculateFibonacci.CacheInfo();
            lastFibo.fibo = 1;
            lastFibo.n = 1;
            return lastFibo.fibo;
        }
        int c = 0;
        for (int i = 2; i != n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        lastFibo = new CalculateFibonacci.CacheInfo();
        lastFibo.fibo = c;
        lastFibo.n = n;
        return lastFibo.fibo;
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;
    }
}
