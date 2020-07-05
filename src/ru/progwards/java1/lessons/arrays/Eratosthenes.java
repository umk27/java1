package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {

    public static void main(String[] args) {
        Eratosthenes eratosthenes = new Eratosthenes(20);
        eratosthenes.sift();
        System.out.println(eratosthenes.isSimple(4));
        System.out.println(eratosthenes.isSimple(15));

    }

    private boolean[] sieve;

    public Eratosthenes(int N) {
        this.sieve = new boolean[N];
        for (int i = 0; i < N; i++) {
            this.sieve[i] = true;
        }
    }

    private void sift() {
        for (int i = 2; i < sieve.length; i++) {
            for (int j = 2; j < sieve.length; j++) {
                if (i * j < sieve.length) sieve[i * j] = false;

            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n - 1];
    }

}
