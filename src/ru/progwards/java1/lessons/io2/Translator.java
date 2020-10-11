package ru.progwards.java1.lessons.io2;

import java.util.Arrays;

public class Translator {

    public static void main(String[] args) {
        String[] out = {"Привет", "Мир"};
        String[] in = {"Hello", "World"};
        Translator translator = new Translator(in, out);
        System.out.println(translator.translate("Hello World!"));

    }

    String[] inLang;
    String[] outLang;

    Translator(String[] inLang, String[] outLang) {
        this.inLang = new String[inLang.length];
        this.outLang = new String[outLang.length];
        for (int i = 0; i < inLang.length; i++) {
            this.inLang[i] = inLang[i].toLowerCase();
            this.outLang[i] = outLang[i].toLowerCase();
        }
    }

    public String translate(String sentence) {
        String[] z1 = sentence.split(" ");
        String[] z = new String[z1.length];
        for (int i = 0; i < z1.length; i++) {
            char[] c = z1[i].toCharArray();
            z1[i] = "";
            for (int j = 0; j < c.length; j++) {
                if (Character.isAlphabetic(c[j])) {
                    z1[i] = z1[i] + c[j];
                }
            }
        }

        for (int i = 0; i < z1.length; i++) {
            for (int j = 0; j < inLang.length; j++) {
                if (z1[i].equals(inLang[j])) {
                    z[i] = outLang[j];
                }
                if (z1[i].toLowerCase().equals(inLang[j])) {
                    char[] r = outLang[j].toCharArray();
                    String t = String.valueOf(r[0]);
                    String t1 = String.valueOf(r[0]).toUpperCase();
                    z[i] = outLang[j].replace(t, t1);
                }
            }

        }

        for (int i = 0; i < z1.length; i++) {
            sentence = sentence.replace(z1[i], z[i]);
        }

        return sentence;
    }
}
