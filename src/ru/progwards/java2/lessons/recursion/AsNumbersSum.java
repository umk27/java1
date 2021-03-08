package ru.progwards.java2.lessons.recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class AsNumbersSum {
    public static void main(String[] args) {
        System.out.println(asNumbersSum(6));

    }

    public static boolean b1;

    public static String asNumbersSum(int number) {
        if (number == 0) return "0";
        if (number == 1) return "1";
        String w = "";
        String s = "";
        String s1 = "";
        String z1 = "";
        String s2 = "";
        String z2 = "";
        int n1 = number;
        for (int i = 1; i < number / 2 + 1; i++) {
            int a = n1 - i;
            if (a != 1) {
                s1 = asNumbersSum(a);
                s1 = s1.replaceAll(a + "=", "");
                if (s1.contains("=")) {
                    String[] ss = s1.split("=");
                    s1 = "";
                    for (int j = 0; j < ss.length; j++) {
                        if (j == ss.length - 1) {
                            s1 = s1 + ss[j];
                        } else {
                            s1 = s1 + ss[j] + "+1=";
                        }
                    }
                }
            }
            int b = i;
            if (b != 1) {
                s2 = asNumbersSum(b);
                s2 = s2.replaceAll(b + "=", "");
                if (s2.contains("=")) {
                    String[] ss = s2.split("=");
                    s2 = "";
                    for (int j = 0; j < ss.length; j++) {
                        if (j == ss.length - 1) {
                            s2 = s2 + ss[j];
                        } else {
                            s2 = s2 + ss[j] + "+1=";
                        }

                    }
                }
            }


            if (a == 1 && b == 1) {
                s = s + a + "+" + b;
            } else if (a != 1 && b == 1) {
                s = s + a + "+" + b + "=" + s1 + "+" + b;

            } else if (a != 1 && b != 1) {
                s = s + "=" + a + "+" + b + "=" + s1 + "+" + s2;
                String[] ss = s.split("=");
                s = "";
                ArrayList<String> sss = new ArrayList<>();
                for (int j = 0; j < ss.length; j++) {
                    boolean bb = true;
                    String z = ss[j].replace("+", "");
                    char[] c = z.toCharArray();
                    int y = 0;
                    for (int x = 0; x < c.length; x++) {
                        y = y + Integer.parseInt(String.valueOf(c[x]));
                    }
                    if (y != number) bb = false;
                    if (!sss.contains(ss[j]) && bb) {
                        sss.add(ss[j]);
                    }
                }
                sss.sort(String::compareTo);
                for (int j = sss.size() - 1; j >= 0; j--) {
                    if (j == 0) {
                        s = s + sss.get(j);
                    } else {
                        s = s + sss.get(j) + "=";
                    }

                }
            }


        }
        return number + "=" + s;
    }


    public static String asNumbersSum1(int number) {
        if (number == 0) return "0";
        if (number == 1) return "1";
        String s = number + "=";
        String z1 = "";
        String z2 = "";
        String s1 = "";

        int number1 = number - 1;
        s1 = asNumbersSum1(number1);
        s1 = s1.replaceAll(number1 + "=", "");
        if (s1.contains("=")) {
            int i1 = s1.indexOf("=");
            z1 = s1.substring(0, i1);
            z2 = z1 + "+" + "1";
            s1 = s1.replace(z1, z2);
        }
        if (s1.equals("1")) {
            s = s + number1 + "+" + "1";
        } else {
            s = s + number1 + "+" + "1" + "=" + s1 + "+" + "1";
        }


        return s;
    }
}







