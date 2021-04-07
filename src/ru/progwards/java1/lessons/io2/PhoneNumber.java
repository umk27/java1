package ru.progwards.java1.lessons.io2;

public class PhoneNumber {

    public static void main(String[] args) {

        System.out.println(format("8(903)560-92-09"));


    }

    public static String format(String phone) {
        char[] a = phone.toCharArray();
        StringBuilder s = new StringBuilder();
        for (char c : a) {
            if (Character.isDigit(c)) {
                s = s.append(c);
            }
        }
        if (s.length() != 10 && s.length() != 11) {
            throw new RuntimeException();
        }

        String z = "+7" + s.toString().substring(1);
        z = z.substring(0, 2) + "(" + z.substring(2, 5) + ")" + z.substring(5, 8) + "-" + z.substring(8);
        return z;
    }


}

