package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrderQueue {

    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();
        Order a = new Order(21000);
        Order b = new Order(25000);
        Order c = new Order(18000);
        Order d = new Order(8000);
        Order v = new Order(20000);
        orderQueue.add(a);
        orderQueue.add(b);
        orderQueue.add(c);
        orderQueue.add(d);
        orderQueue.add(v);
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
        System.out.println(orderQueue.get().getSum());
    }

    static Queue<Order> first = new ArrayDeque<>();
    static Queue<Order> second = new ArrayDeque<>();
    static Queue<Order> third = new ArrayDeque<>();

    public void add(Order order) {
        if (order.getSum() > 20000) {
            first.add(order);
        } else if (order.getSum() <= 20000 && order.getSum() > 10000) {
            second.add(order);
        } else {
            third.add(order);
        }
    }

    public Order get() {
        if (first.size() != 0) {
            return first.poll();
        } else if (second.size() != 0) {
            return second.poll();
        } else if (third.size() != 0) {
            return third.poll();
        } else {
            return null;
        }
    }
}

