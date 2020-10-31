package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        System.out.println(union(set1, set2));
        System.out.println(intersection(set1, set2));
        System.out.println(difference(set1, set2));
        System.out.println(symDifference(set1, set2));
    }

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        HashSet<Integer> z = new HashSet<>(set1);
        result.addAll(set2);
        z.retainAll(set2);
        result.removeAll(z);
        return result;
    }
}
