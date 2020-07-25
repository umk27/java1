package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    private static CyclesGoldenFibo.CacheInfo lastFibo;

    public int fiboNumber(int n) {
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

    public CyclesGoldenFibo.CacheInfo getLastFibo() {
        return lastFibo;
    }

    public void clearLastFibo() {
        lastFibo = null;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;
    }
}
