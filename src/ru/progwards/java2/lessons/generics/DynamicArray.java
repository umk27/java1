package ru.progwards.java2.lessons.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T> {

    public static void main(String[] args) {
        Integer[] a = {4, 10, 1, 7, 9, 5, 3, 8, null, null};
        Integer b = 12;
        DynamicArray da = new DynamicArray(a);
        da.add(55);

    }

    private T[] a;

    public DynamicArray(T[] a) {
        this.a = a;
    }

    public void add(T b) {
        boolean bo = false;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == null && a[i - 1] != null) {
                a[i] = b;
                bo = true;
                break;
            }
            if (a[i] != null) {
                break;
            }
        }

        if (bo == false) {
            int x = a.length;
            a = Arrays.copyOf(a, 2 * a.length);
            a[x] = b;

        }
        System.out.println(Arrays.toString(a));

    }

    public void insert(int pos, T b) {
        boolean bo = false;
        if (a[a.length - 1] != null) {
            a = Arrays.copyOf(a, 2 * a.length);
        }

        for (int i = a.length - 1; i > pos; i--) {
            if (a[i] == null && a[i - 1] != null) {
                bo = true;
            }
            if (bo == true) {
                a[i] = a[i - 1];
            }
        }
        a[pos] = b;
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);
    }

    public void remove(int pos) {
        for (int i = pos; i < a.length-1; i++) {
            if (a[i] == null & a[i + 1] == null) {
                break;
            }
            a[i] = a[i + 1];
        }
        if (a[a.length - 1] != null) a[a.length - 1] = null;

        System.out.println(Arrays.toString(a));
    }

    public T get(int pos) {
        return a[pos];
    }

    public int size() {
        int i1=0;
        for(int i=0; i<a.length; i++) {
            if (a[i]!=null){
                i1++;
            }

        }
        return i1;
    }


}
