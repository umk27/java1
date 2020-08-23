package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight<Food> {

    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(Food smthHasWeigt) {
        if (this.weight < smthHasWeigt.weight) return CompareResult.LESS;
        if (this.weight > smthHasWeigt.weight) return CompareResult.GREATER;
        else return CompareResult.EQUAL;
    }

    @Override
    public void sort(Food[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER) {
                    Food b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
    }
}
