package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private int row;
    private int col;

    MatrixIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {

        return row < array.length && col < array[row].length;
    }

    @Override
    public T next() {
        T nextValue = array[row][col++];
        if (col >= array[row].length) {
            row++;
            col = 0;
        }
        return nextValue;
    }

    public static void main(String[] args) {
        MatrixIterator<Integer> matrixIterator = new MatrixIterator<>(new Integer[][]{{5, 3, 8, 9, 5}, {1, 1, 4, 6, 8}, {6666, 7, 8, 99}});
        while (matrixIterator.hasNext()) {
            System.out.println(matrixIterator.next());
        }
    }
}
