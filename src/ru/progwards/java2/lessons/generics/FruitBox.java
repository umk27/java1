package ru.progwards.java2.lessons.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FruitBox<Fruit> extends ArrayList {

    public static void main(String[] args) {
        FruitBox f1 = new FruitBox<>();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();
        f1.add(o1);
        f1.add(o2);
        f1.add(o3);
        FruitBox f2 = new FruitBox<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        f2.add(a1);
        f2.add(a2);
        f2.add(a3);
        FruitBox f3 = new FruitBox<>();
        Orange o4 = new Orange();
        Orange o5 = new Orange();
        Orange o6 = new Orange();
        f3.add(o4);
        f3.add(o5);
        f3.add(o6);

        System.out.println(f1.сompareTo(f2));
        System.out.println(f2.сompareTo(f3));
        System.out.println(f1.сompareTo(f3));

    }


    @Override
    public boolean add(Object o) {
        if (this.size() != 0) {
            if (o.getClass().equals(this.get(0).getClass())) {
                return super.add(o);
            } else {
                return false;
            }
        } else {
            return super.add(o);
        }
    }

    public float getWeight() {
        float w1 = 0;
        float w = 0;
        if (this.get(0).getClass().equals(Apple.class)) w = 1.0f;
        if (this.get(0).getClass().equals(Orange.class)) w = 1.5f;
        for (int i = 0; i < this.size(); i++) {
            w1 = w1 + w;
        }
        return w1;
    }

    public void moveTo(FruitBox<Fruit> fb1) {
        if (fb1.get(0).getClass().equals(this.get(0).getClass())) {
            for (int i = 0; i < this.size(); i++) {
                fb1.add(this.get(i));
                this.remove(i);
            }
        } else {
            throw new UnsupportedOperationException();
        }

    }

    public int сompareTo(FruitBox<Fruit> fb1) {
        if (this.getWeight() < fb1.getWeight()) {
            return -1;
        } else if (this.getWeight() > fb1.getWeight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
