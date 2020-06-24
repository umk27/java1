package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    public static void main(String[] args) {
        System.out.println(isTriangle(4,1,5));
        System.out.println(isRightTriangle(4, 1, 5));
        System.out.println(isIsoscelesTriangle(3, 3, 5));
    }

    public static boolean isTriangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) return true;
        else return false;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        if (a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a) return true;
        else return false;
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        if (a==b || a==c || b==c) return true;
        else return false;
    }
}
