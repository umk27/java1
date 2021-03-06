package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public static void main(String[] args) {
        System.out.println(calculateAccuracy(6371.2));
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat(6371.2f));
    }

    public static double volumeBallDouble(double radius) {
        float pi = 3.14f;
        return 4f / 3f * pi * Math.pow(radius, 3);

    }

    public static float volumeBallFloat(float radius) {
        float pi = 3.14f;
        return 4f / 3f * pi * (float) Math.pow(radius, 3);
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float) radius);
    }

}
