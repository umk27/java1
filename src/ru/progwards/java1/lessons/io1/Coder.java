package ru.progwards.java1.lessons.io1;

import org.w3c.dom.ls.LSOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {

    public static void main(String[] args) {
        char[] code = {'9', '8', '7', '6', '5', '4', '3', '2'};
        codeFile("t1.txt", "t2.txt", code, "t3.txt");
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        boolean first = true;
        int q = 0;
        String z = "";
        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                if (!first) {
                    z = z + "\n";
                }
                first = false;
                String a = scanner.nextLine();
                char[] oldcode = a.toCharArray();
                char[] code1 = new char[oldcode.length];
                for (int i = 0; i < oldcode.length; i++) {
                    String w = String.valueOf(oldcode[i]);
                    System.out.println(w);
                    code1[i] = code[Integer.parseInt(w)];

                }
                String z1 = new String(code1);
                z = z + z1;
            }
            reader.close();
        } catch (Exception e) {
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
        } catch (Exception e) {
            try {
                FileWriter writer1 = new FileWriter(logName);
                writer1.write(e.getMessage());
                writer1.close();
            } catch (Exception r) {

            }
        }
    }
}
