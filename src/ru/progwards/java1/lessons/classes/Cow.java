package ru.progwards.java1.lessons.classes;

public class Cow extends Animal {

    Cow(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        return 0.05;
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
