package ru.progwards.java1.lessons.maps;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {

    public static void main(String[] args) {
        SalesInfo salesInfo = new SalesInfo();
        System.out.println(salesInfo.loadOrders("W2.txt"));
        System.out.println(salesInfo.getGoods());


    }

    HashMap<Integer, String[]> map = new HashMap<>();

    public int loadOrders(String fileName) {
        int n = 0;
        try (FileReader reader = new FileReader(fileName)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String a = scanner.nextLine();
                String[] s = a.split(",");
                for (int i = 0; i < s.length; i++) {
                    s[i] = s[i].trim();
                }
                Integer i = Integer.valueOf(s[2]);
                Double d = Double.valueOf(s[3]);
                if (s.length == 4 && i != null && d != null) {
                    n = n + 1;
                    map.put(n, s);
                }
            }
        } catch (IOException E) {

        }
        return n;
    }

    public Map<String, Double> getGoods() {
        LinkedHashMap<String, Double> result = new LinkedHashMap<>();
        double a = 0;
        for (int i = 1; i <= map.size(); i++) {
            String[] s = map.get(i);
            a = Double.valueOf(s[3]);
            for (int j = 1; j <= map.size(); j++) {
                String[] z = map.get(j);
                if (s[1].equals(z[1])) {
                    a = a + Double.valueOf(z[3]);
                }
            }
            if (!result.containsKey(s[1])) {
                result.put(s[1], a);
            }
        }
        return result;
    }

  // public Map<String, AbstractMap.Entry<Double, Integer>> getCustomers() {
     //   double a = 0;
     //   int b = 0;
     //   LinkedHashMap<String, AbstractMap.SimpleEntry<Double, Integer>> result = new LinkedHashMap<>();
     //   List<String> list = new ArrayList();
     //   Map<Double, Integer> map2 = new HashMap<>();
     //   for (int i = 1; i <= map.size(); i++) {
      //      String[] s = map.get(i);
      //      a = Double.valueOf(s[3]);
       //     b = Integer.valueOf(s[2]);
       //     list.add(s[0]);
       //     for (int j = 1; j <= map.size(); j++) {
//
  //              String[] z = map.get(j);
   //             if (s[0].equals(z[0])) {
    //                a = a + Double.valueOf(z[3]);
     //               b = b + Integer.valueOf(z[2]);
     //           }
      //      }
     //       if (!map2.containsKey(a)) {
     //           map2.put(a, b);

      //      }
     //   }
     //   Set<AbstractMap.Entry<Double, Integer>> entries = map2.entrySet();

     //   for (int i = 0; i < list.size(); i++) {
      //      char[] c = list.get(i).toCharArray();
      //      for (int j = 0; j < list.size(); j++) {
       //         char[] v = list.get(j).toCharArray();
       //         if ((int) v[0] < (int) c[0]) {
        //            c[0] = v[0];
       //         }
       //     }
       //    result.put(String.valueOf(c[0]), );
      //  }
      //  return result;
  //  }

}
