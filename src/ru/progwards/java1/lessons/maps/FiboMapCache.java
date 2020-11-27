package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {

    public static void main(String[] args) {
        FiboMapCache fiboMapCache = new FiboMapCache(false);
        for (int i = 1; i <= 20; i++) {
            System.out.println(fiboMapCache.fiboNumber(i));
        }
        //     test();
    }

    private static Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    private boolean cache;

    public FiboMapCache(boolean cacheOn) {
       // if (cacheOn) {
       //     setfiboCache();
      //  }
        this.cache = cacheOn;

    }

    public static void setfiboCache() {
        for (int j = 1; j <= 1000; j++) {
            BigDecimal a = new BigDecimal("1");
            BigDecimal b = new BigDecimal("1");
            if (j == 1 || j == 2) {
                fiboCache.put(j, BigDecimal.ONE);


            }
            BigDecimal c = new BigDecimal("1");
            if (j != 1 && j != 2) {
                for (int i = 2; i != j; i++) {
                    c = a.add(b);
                    a = b;
                    b = c;
                }
                fiboCache.put(j, c);

            }

        }
    }

    public BigDecimal fiboNumber(int n) {
        if (cache) {
            return fiboCache.get(n);
        }
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1");
        if (n == 1 || n == 2) {
            if (!fiboCache.containsKey(n)) {
                fiboCache.put(n, BigDecimal.ONE);
           }
            return BigDecimal.ONE;
        }
        BigDecimal c = new BigDecimal("1");
        for (int i = 2; i != n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }
       if (!fiboCache.containsKey(n)) {
            fiboCache.put(n, c);
       }
        return c;
    }

    public void clearCahe() {
        fiboCache.clear();
    }

    public static void test() {
        FiboMapCache fiboMapCache = new FiboMapCache(false);
        for (int i = 1; i <= 1000; i++) {
            fiboMapCache.fiboNumber(i);
        }

        FiboMapCache fiboMapCacheOn = new FiboMapCache(true);
        FiboMapCache fiboMapCacheOff = new FiboMapCache(false);
        long start1 = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            fiboMapCacheOn.fiboNumber(i);
        }
        long a = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            fiboMapCacheOff.fiboNumber(i);
        }
        long b = System.nanoTime() - start2;

        System.out.println("fiboNumber cacheOn= true время выполнения " + a);
        System.out.println("fiboNumber cacheOn= false время выполнения " + b);
    }
}
