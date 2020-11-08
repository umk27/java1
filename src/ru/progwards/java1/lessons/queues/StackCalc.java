package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackCalc {

    public static Deque<Double> deque = new ArrayDeque<>();

    public void push(double value) {
        deque.addFirst(value);
    }

    public double pop() {
        return deque.pollFirst();
    }

    public void add() {
        double a = deque.pollFirst();
        double b = deque.pollFirst();
        deque.addFirst(a + b);
    }

    public void sub() {
        double a = deque.pollFirst();
        double b = deque.pollFirst();
        deque.addFirst(b - a);
    }

    public void mul() {
        double a = deque.pollFirst();
        double b = deque.pollFirst();
        deque.addFirst(a * b);
    }

    public void div() {
        double a = deque.pollFirst();
        double b = deque.pollFirst();
        deque.addFirst(b / a);
    }


}
