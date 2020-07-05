package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    public static void main(String[] args) {
        int[] m1 = {1, 2, 3, 4, 5};
        int[] m2 = {9, 8, 7, 6, 5};
        int[] m3 = {4, 5, 6, 7, 8};
        DIntArray dIntArray1 = new DIntArray(m1);
        dIntArray1.atInsert(2, 10);
        DIntArray dIntArray2 = new DIntArray(m2);
        dIntArray2.add(10);
        DIntArray dIntArray3 = new DIntArray(m3);
        dIntArray3.atDelete(3);

    }

    private int[] mass;

    public DIntArray(int[] mass) {
        this.mass = mass;
    }

    public void add(int num) {
        int[] mass1 = Arrays.copyOf(mass, mass.length + 1);
        mass1[mass.length] = num;
        mass = Arrays.copyOf(mass1, mass1.length);
        System.out.println(Arrays.toString(mass));
    }

    public void atInsert(int pos, int num) {
        int[] mass1 = new int[mass.length + 1];
        System.arraycopy(mass, 0, mass1, 0, mass.length);
        for (int i = pos; i < mass.length; i++) {
            mass1[i + 1] = mass[i];
        }
        mass1[pos] = num;
        mass = Arrays.copyOfRange(mass1, 0, mass1.length);
        System.out.println(Arrays.toString(mass1));
    }

    public void atDelete(int pos) {
        int[] mass1 = new int[mass.length];
        System.arraycopy(mass, 0, mass1, 0, mass.length);
        for (int i = pos; i < mass1.length - 1; i++) {
            mass1[i] = mass1[i + 1];
        }
        mass = Arrays.copyOfRange(mass1, 0, mass1.length - 1);
        System.out.println(Arrays.toString(mass));
    }

    public int at(int pos) {
        return mass[pos];
    }
}
