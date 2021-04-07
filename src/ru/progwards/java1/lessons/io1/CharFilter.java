package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {

    public static void main(String[] args) {
        filterFile("Text1.txt", "Text2.txt", " -,.()");
    }

    public static void filterFile(String inFileName, String outFileName, String filter) {
        char[] f = filter.toCharArray();
        boolean first = true;
        String z = "";
        String z1 = "";
        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                if (!first) {
                    z = z + "\n";
                }
                first = false;
                z1 = scanner.nextLine();
                for (int i = 0; i < f.length; i++) {
                    String b = String.valueOf(f[i]);
                    z1 = z1.replace(b, "");
                }
                z = z + z1;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(-1);
        }

        try {
            FileWriter writer = new FileWriter(outFileName);
            writer.write(z);
            writer.close();
        } catch (Exception e) {

        }

    }
}
