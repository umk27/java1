package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal {

    Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        return 0.03;
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
        return "I am "+ getKind()+", eat "+ getFoodKind();
    }
}
