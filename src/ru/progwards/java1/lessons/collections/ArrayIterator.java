package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    public static void main(String[] args) {
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(new Integer[]{1, 2, 3, 4, 5});
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }

    private T[] array;
    private int a;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {

        return a < array.length;
    }

    @Override
    public T next() {

        return array[a++];
    }
}

