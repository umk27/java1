package ru.progwards.java2.lessons.recursion;

import java.time.Instant;

public class Goods {

    public Goods(String name, String number, int available, double price, Instant expired) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;
    }

    String name;
    String number;
    int available;
    double price;
    Instant expired;


}
