package ru.progwards.java1.lessons.classes;

public class Animal {

    public static void main(String[] args) {
        Cow cow = new Cow (300);
        System.out.println(cow.toStringFull());
        System.out.println(cow.toString());
    }

    double weight;

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
        return "I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>";
    }

    @Override
    public String toString() {
        return "I am <AnimalKind>, eat <FoodKind>";
    }
}
