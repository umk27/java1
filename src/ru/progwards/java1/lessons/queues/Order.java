package ru.progwards.java1.lessons.queues;

public class Order {

    private static int i;

    private double sum;

    private int num;

    public Order(double sum) {
        i = i + 1;
        num = i;
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }
}
