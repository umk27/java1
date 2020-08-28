package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;
import java.util.Objects;

public class Animal implements FoodCompare, CompareWeight<Animal> {

    public static void main(String[] args) {
        Cow cow = new Cow(300);
        Duck duck = new Duck(5);
        Hamster hamster = new Hamster(5);
        Animal[] animals = {duck, cow, hamster, cow, duck, cow};

    }


    double weight;

    public CompareResult compareWeight(Animal smthHasWeigt) {
        if (this.weight < smthHasWeigt.weight) return CompareResult.LESS;
        if (this.weight > smthHasWeigt.weight) return CompareResult.GREATER;
        else return CompareResult.EQUAL;
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

    @Override
    public void sort(Animal[] a) {

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
