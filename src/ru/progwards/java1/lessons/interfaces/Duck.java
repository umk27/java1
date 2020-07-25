package ru.progwards.java1.lessons.interfaces;

import ru.progwards.java1.lessons.interfaces.Animal;

public class Duck extends Animal {

    Duck(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.DUCK;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.04;
    }

    @Override
    public double calculateFoodWeight() {
        return weight * getFoodCoeff();
    }

    @Override
    public String toStringFull() {
        return "I am " + getKind() + ", eat " + getFoodKind()+ " " + calculateFoodWeight();
    }

    @Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }
}
