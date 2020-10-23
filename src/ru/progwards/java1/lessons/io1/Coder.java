package ru.progwards.java1.lessons.io1;

import org.w3c.dom.ls.LSOutput;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {

    public static void main(String[] args) {
        byte b = 13;
        char c = (char) b;
        System.out.println("char c="+c);
        int i = Integer.valueOf(c);
        System.out.println("int i="+i);
        String s = String.valueOf(c);
        System.out.println("String s="+s);
        int ii = Integer.parseInt(s);
        System.out.println("int ii="+ii);
     //   char[] code = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
     //   codeFile("t1.txt", "t2.txt", code, "t3.txt");
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        boolean first = true;
        String z = "";
        try {
            FileInputStream bytefile = new FileInputStream(inFileName);
            byte[] b = bytefile.readAllBytes();
            System.out.println(Arrays.toString(b));
            char[] c = new char[b.length];
            char[] code1 = new char[b.length];
            for (int i = 0; i < b.length - 2; i++) {
                if (i != 4 && i != 5) {
                    c[i] = (char) b[i];
                    //System.out.println(c[i]);
                    Double d = Double.valueOf(c[i]);
                    System.out.println(d);
                    BigDecimal bd = new BigDecimal(c[i]);
                    BigInteger bi = bd.toBigInteger();
                    Integer q = bi.intValue();
                    String w = String.valueOf(c[i]);
                    //System.out.println(w);
                    // code1[i] = code[c[i]];
                 //   System.out.println(code[i]);
                }
            }
            z = new String(code1);
            System.out.println(z);
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
