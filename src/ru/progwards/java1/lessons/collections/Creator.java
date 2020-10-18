package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Creator {

    public static void main(String[] args) {
        System.out.println(fill3(3));
    }

    public static Collection<Integer> fillEven(int n) {
        Collection<Integer> collection = new LinkedList();
        for (int i = 1; i <= n; i++) {
            collection.add(i * 2);
        }
        return collection;
    }

    public static Collection<Integer> fillOdd(int n) {
        Collection<Integer> collection = new ArrayList();
        for (int i = n; i > 0; i--) {
            collection.add(i * 2 - 1);
        }
        return collection;
    }

    public static Collection<Integer> fill3(int n) {
        Collection<Integer> collection = new LinkedList();
        for (int i = 0; i <= n; i++) {
            int a = i * i;
            int b = i * i * i;
            collection.add(i);
            collection.add(a);
            collection.add(b);
            i = i + 3;

        }
        return collection;
    }
}
