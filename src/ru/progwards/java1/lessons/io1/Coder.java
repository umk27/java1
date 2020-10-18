package ru.progwards.java1.lessons.io1;

import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {

    public static void main(String[] args) {
        char ch10 = (char) 10;
        char ch13 = (char) 13;
        System.out.println(ch10);
        System.out.println(ch13);
       // char[] code = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
       // codeFile("t1.txt", "t2.txt", code, "t3.txt");
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        boolean first = true;
        int q = 0;
        String z = "";
        try {
            FileInputStream bytefile = new FileInputStream(inFileName);
            byte[] b = bytefile.readAllBytes();
            System.out.println(Arrays.toString(b));
            char[] c = new char[b.length];
            char[] code1 = new char[b.length];
            for (int i = 0; i < b.length; i++) {
                if (i != 4 && i != 5) {
                    c[i] = (char) b[i];
                    System.out.println(Arrays.toString(c));  // Как преобразовать в char символ перехода на следующую строку в байтах?
                    String w = String.valueOf(c[i]);
                    code1[i] = code[Integer.valueOf(w)];
                }
            }
            z = new String(code1);
            bytefile.close();
        } catch (
                Exception e) {
            try {
                FileWriter writer1 = new FileWriter(logName);
                writer1.write(e.getMessage());
                writer1.close();
            } catch (Exception r) {

            }
        }
        try {
            FileWriter writer = new FileWriter(outFileName);
            writer.write(z);
            writer.close();
        } catch (
                Exception e) {
            try {
                FileWriter writer1 = new FileWriter(logName);
                writer1.write(e.getMessage());
                writer1.close();
            } catch (Exception r) {

            }
        }
    }
}
