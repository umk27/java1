package ru.progwards.java1.lessons.queues;

import static ru.progwards.java1.lessons.queues.StackCalc.deque;

public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }

    public static double calculation1() {
        StackCalc stackCalc = new StackCalc();
        stackCalc.push( 3);
        stackCalc.push(12.1);
        stackCalc.add();
        stackCalc.push(2.2);
        stackCalc.mul();
        return stackCalc.pop();
    }

    public static double calculation2() {
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(9.2);
        stackCalc.push(13.001);
        stackCalc.add();
        stackCalc.push(2);
        stackCalc.mul();
        stackCalc.push(87);
        stackCalc.add();
        double a = stackCalc.pop();
        stackCalc.push(19);
        stackCalc.push(3.33);
        stackCalc.sub();
        stackCalc.push(a);
        stackCalc.mul();
        double b = stackCalc.pop();
        stackCalc.push(55.6);
        stackCalc.push(12.1);
        stackCalc.sub();
        double c = stackCalc.pop();
        stackCalc.push(737.22);
        stackCalc.push(24);
        stackCalc.add();
        double e = stackCalc.pop();
        stackCalc.push(e);
        stackCalc.push(c);
        stackCalc.div();
        stackCalc.push(b);
        stackCalc.add();
        return stackCalc.pop();
    }
}
