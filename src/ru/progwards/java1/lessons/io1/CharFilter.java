package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {

    public static void main(String[] args) {
        filterFile("Text1.txt", "Text2.txt", "-,.()");
    }

    public static void filterFile(String inFileName, String outFileName, String filter) {
        char[] f = filter.toCharArray();
        String z = "";
        String z1 = "";
        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();
                char[] oldcode = a.toCharArray();
                for (int j = 0; j < f.length; j++) {
                    String q = String.valueOf(f[j]);
                    for (int i = 0; i < oldcode.length; i++) {
                        String w = String.valueOf(oldcode[i]);
                        if (w.equals(q)) {
                            for (int k = i; i < oldcode.length - 1 - i; i++) {
                                oldcode[k] = oldcode[k + 1];
                            }
                        }
                    }
                }
                z1 = new String(oldcode);
                z = z + z1 + "\n";
                System.out.println(z);
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
