package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {

    public static void main(String[] args) {
        Product milk = new Product("Молоко");
        Product aggs = new Product("Яйца");
        Product shugar = new Product("Сахар");
        Product meal = new Product("Мука");
        Product buckwheat = new Product("Гречка");
        List<Product> prod1 = new ArrayList<>();
        prod1.add(milk);
        prod1.add(aggs);
        List<Product> prod2 = new ArrayList<>();
        prod2.add(milk);
        prod2.add(aggs);
        prod2.add(shugar);
        List<Product> prod3 = new ArrayList<>();
        prod3.add(milk);
        prod3.add(aggs);
        prod3.add(shugar);
        prod3.add(meal);
        Shop Magnit = new Shop(prod1);
        Shop Dixi = new Shop(prod2);
        Shop Pyatiorochka = new Shop(prod3);
        Collection<Product> product = new HashSet<>();
        product.addAll(prod1);
        product.addAll(prod2);
        product.addAll(prod3);
        product.add(buckwheat);
        List<Product> products = new ArrayList<>();
        products.addAll(product);
        List<Shop> shops = new ArrayList<>();
        shops.add(Magnit);
        shops.add(Dixi);
        shops.add(Pyatiorochka);
        ProductAnalytics productAnalytics = new ProductAnalytics(products, shops);
        Set<Product> result1 = productAnalytics.existInAll();
        for (Product r : result1) {
            System.out.println(r.getCode());
        }
        System.out.println("//");
        System.out.println("//");
        Set<Product> result2 = productAnalytics.existAtListInOne();
        for (Product r : result2) {
            System.out.println(r.getCode());
        }
        System.out.println("//");
        System.out.println("//");
        Set<Product> result3 = productAnalytics.notExistInShops();
        for (Product r : result3) {
            System.out.println(r.getCode());
        }
        System.out.println("//");
        System.out.println("//");
        Set<Product> result4 = productAnalytics.existOnlyInOne();
        for (Product r : result4) {
            System.out.println(r.getCode());
        }
    }

    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.products = products;

    }

    public Set<Product> existInAll() {
        boolean a;
        Set<Product> pro = new HashSet<>();
        for (int i = 0; i < products.size(); i++) {
            Product pr = products.get(i);
            a = true;
            for (int j = 0; j < shops.size(); j++) {
                Shop sh = shops.get(j);
                if (!sh.getProducts().contains(pr)) {
                    a = false;
                }
            }
            if (a == true) {
                pro.add(pr);
            }

        }
        return pro;

    }

    public Set<Product> existAtListInOne() {
        boolean a;
        Set<Product> pro = new HashSet<>();
        for (int i = 0; i < products.size(); i++) {
            Product pr = products.get(i);
            a = false;
            for (int j = 0; j < shops.size(); j++) {
                Shop sh = shops.get(j);
                if (sh.getProducts().contains(pr)) {
                    a = true;
                }
            }
            if (a == true) {
                pro.add(pr);
            }

        }
        return pro;

    }

    public Set<Product> notExistInShops() {
        boolean a;
        Set<Product> pro = new HashSet<>();
        for (int i = 0; i < products.size(); i++) {
            Product pr = products.get(i);
            a = false;
            for (int j = 0; j < shops.size(); j++) {
                Shop sh = shops.get(j);
                if (sh.getProducts().contains(pr)) {
                    a = true;
                }
            }
            if (a == false) {
                pro.add(pr);
            }

        }
        return pro;
    }

    public Set<Product> existOnlyInOne() {
        boolean a;
        int n;
        Set<Product> pro = new HashSet<>();
        for (int i = 0; i < products.size(); i++) {
            Product pr = products.get(i);
            a = false;
            n = 0;
            for (int j = 0; j < shops.size(); j++) {
                Shop sh = shops.get(j);
                if (sh.getProducts().contains(pr)) {
                    n = n + 1;
                    a = true;
                }
            }
            if (a == true && n == 1) {
                pro.add(pr);
            }

        }
        return pro;
    }
}



