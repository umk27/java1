package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    public static void main(String[] args) {
      //  DIntArray dIntArray1 = new DIntArray();
     //   dIntArray1.atInsert(2, 10);
      //  System.out.println(dIntArray1.at(2));
      //  DIntArray dIntArray2 = new DIntArray();
      //  dIntArray2.add(10);
      //  System.out.println(dIntArray2.at(2));
      //  DIntArray dIntArray3 = new DIntArray();
      //  dIntArray3.atDelete(3);
      //  System.out.println(dIntArray2.at(5));

    }

    private int[] mass = {1, 2, 3, 4, 5, 6, 7, 8, 9};


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
