package ru.progwards.java1.lessons.io2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {

    public static void main(String[] args) {
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems"};
        censorFile("????.txt", obscene);
    }

    public static class CensorException extends RuntimeException {
        public String filename = "";

        public CensorException(String filename) {
            super("Неправильное имя файла");
            this.filename = filename;
        }

        @Override
        public String getMessage() {
            return super.getMessage() + ":" + filename;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) {
        String z = "";
        String s = "";
        try (FileReader reader = new FileReader(inoutFileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                s = scanner.nextLine();
                for (int i = 0; i < obscene.length; i++) {
                    char[] c = obscene[i].toCharArray();
                    for (int j = 0; j < c.length; j++) {
                        z = z + "*";
                    }
                    s = s.replace(obscene[i], z);
                    z = "";
                }
            }
        } catch (Exception e) {
          throw new CensorException(inoutFileName);
        }
        System.out.println(s);
        try (FileWriter writer = new FileWriter(inoutFileName)) {
            writer.write(s);
        } catch (Exception e) {
           throw new CensorException(inoutFileName);
        }

    }

}
