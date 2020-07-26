package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;
import java.util.Objects;

public class Animal implements FoodCompare, CompareWeight<Animal> {

    public static void main(String[] args) {
        Cow cow = new Cow(300);
        Duck duck = new Duck(5);
        Hamster hamster = new Hamster(5);
        Animal[] animals = {cow, duck, hamster};
        System.out.println(duck.compareWeight(cow));
        System.out.println(cow.compareWeight(duck));
        System.out.println(duck.compareWeight(hamster));
        System.out.println(new Food((int) cow.calculateFoodWeight()).compareWeight(new Food((int) duck.calculateFoodWeight())));
        System.out.println(new Food((int) duck.calculateFoodWeight()).compareWeight(new Food((int) cow.calculateFoodWeight())));
        System.out.println(new Food((int) duck.calculateFoodWeight()).compareWeight(new Food((int) hamster.calculateFoodWeight())));
    }


    double weight;

    public CompareResult compareWeight(Animal smthHasWeigt) {
        if (this.weight < smthHasWeigt.weight) return CompareResult.LESS;
        if (this.weight > smthHasWeigt.weight) return CompareResult.GREATER;
        else return CompareResult.EQUAL;
    }

    @Override
    public void sort(Animal[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j])==CompareResult.GREATER) {
                    Animal b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    public Animal(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY:
                return 20;
            case CORN:
                return 50;
        }
        return 0;
    }



    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    public int compareFoodPrice(Animal aminal) {
        return Double.compare(getFoodPrice(), aminal.getFoodPrice());
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return weight * getFoodCoeff();
    }

    public String toStringFull() {
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    @Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }
}
