package ru.progwards.java1.lessons.classes;

public class ComplexNum {

    public static void main(String[] args) {

        ComplexNum num1 = new ComplexNum(7, -4);
        ComplexNum num2 = new ComplexNum(3, 2);
        ComplexNum num3 = num1.add(num2);
        System.out.println(num3.toString());
        ComplexNum num4 = num1.sub(num2);
        System.out.println(num4.toString());
        ComplexNum num5 = num1.mul(num2);
        System.out.println(num5.toString());
        ComplexNum num6 = num1.div(num2);
        System.out.println(num6.toString());

    }

    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return Integer.toString(a) + "+(" + Integer.toString(b) + "i)";
    }

    public ComplexNum add(ComplexNum num) {
        int x = a + num.a;
        int y = b + num.b;
        return new ComplexNum(x, y);
    }

    public ComplexNum sub(ComplexNum num) {
        int x = a - num.a;
        int y = b + num.b;
        return new ComplexNum(x, y);
    }

    public ComplexNum mul(ComplexNum num) {
        int x = (a * num.a - b * num.b);
        int y = (a * num.b + b * num.a);
        return new ComplexNum(x, y);
    }

    public ComplexNum div(ComplexNum num) {
        int x = (a * num.a + b * num.b) / (num.a * num.a + num.b * num.b);
        int y = (num.a * b - num.b * a) / (num.a * num.a + num.b * num.b);
        return new ComplexNum(x, y);
    }

}
