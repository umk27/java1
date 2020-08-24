package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    public static void main(String[] args) {
        System.out.println(fiboNumber(15));

    }

    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {
       // if (n == lastFibo.n) return lastFibo.fibo;
        int a = 1;
        int b = 1;
        if (n == 1 || n == 2) return 1;
        int c = 0;
        for (int i = 2; i != n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
       // lastFibo.fibo = c;    // Не смотря на то что компилятор не выдает ошибки, не удается обратиться к полям
       // lastFibo.n = n;       // класса CacheInfo. Программа не считает.
      //  return lastFibo.fibo;
        return 0;
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static class CacheInfo<CacheInfo> {
        public int n;
        public int fibo;
    }
}
