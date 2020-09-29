package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

    public static void main(String[] args) {
        System.out.println(calcEmpty("t1.txt"));
    }

    public static int calcEmpty(String fileName) {
        int i = 0;
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.equals("")) {
                    i = i + 1;
                }
            }
            reader.close();
        } catch (IOException e) {
            return -1;
        }
        return i;
    }
}
