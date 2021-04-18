package ru.progwards.java2.lessons.basetypes;


import java.util.Arrays;
import java.util.Iterator;

public class DoubleHashTable<K, V> implements Iterable<V> {

    public static void main(String[] args) {

        DoubleHashTable<Integer, Integer> dht = new DoubleHashTable(101);

        dht.add(11, 9);
        dht.add(7, 5);
        dht.add(8, 3);

        int i = 0;
        for (Iterator<Integer> iterator = dht.iterator(); iterator.hasNext(); ) {
            i = i + 1;
            System.out.println(iterator.next());
        }

        //  System.out.println(dht.get(7));
        //   System.out.println(dht.get(11));
        //   dht.remove(11);
        //  System.out.println(dht.get(8));
        //  dht.change(8, 9);
        //  System.out.println(dht.get(9));
    }

    @Override
    public Iterator<V> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<V> {

        Itr() {

        }

        public boolean hasNext() {
            if (i1 == 0) {
                for (int i2 = i1; i2 < table.length; i2++) {
                    if (table[i2] != null) {
                        i1 = i2;
                        break;
                    }
                }
            }
            boolean b = false;
            for (int i2 = i1 + 1; i2 < table.length; i2++) {
                if (table[i2] != null) {
                    b = true;
                    break;
                }
            }

            return b;
        }


        public V next() {
            if (i1 == 0) {
                for (int i2 = i1; i2 < table.length; i2++) {
                    if (table[i2] != null) {
                        i1 = i2;
                        break;
                    }
                }
            }
            V W = null;
            for (int i2 = i1 + 1; i2 < table.length; i2++) {
                if (table[i2] != null) {
                    W = table[i2].getItem();
                    i1 = i2;
                    break;
                }
            }
            return W;

        }

        public void remove() {
            table[i1] = null;
        }
    }


    public static class StringKey<K> implements HashValue {

        private String key;

        public void setKey(K key) {
            this.key = String.valueOf(key);
        }

        @Override
        public int getHash() {
            long b = 378551;
            long a = 63689;
            long hash = 0;
            for (int i = 0; i < key.length(); i++) {
                hash = hash * a + key.charAt(i);
                a = a * b;
            }
            return (int) hash;
        }

    }

    public class IntKey<K> implements HashValue {

        private K key;

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public int getHash() {
            return (int) key % table.length;
        }
    }

    public CHashItem<K, V>[] table;
    int i1 = 0;

    private IntKey intKey = new IntKey();
    private StringKey stringKey = new StringKey();

    class CHashItem<K, V> {

        private V item;
        private K key;
        int i;

        public CHashItem(V item, K key) {
            this.item = item;
            this.key = key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getItem() {
            return item;
        }

        public K getKey() {
            return key;
        }
    }

    DoubleHashTable(int n) {
        table = new CHashItem[n];
    }

    public CHashItem[] getTable() {
        return table;
    }

    public void add(K key, V value) {
        int k = 0;
        int n = 0;
        int ntl = 0;
        boolean b1 = false;

        stringKey.setKey(key);
        int index = stringKey.getHash();
        CHashItem<K, V> chi = new CHashItem<>(value, key);
        if (index < table.length) {
            CHashItem<K, V> head = table[index];
            if (head == null) {
                table[index] = chi;
                b1 = true;
            } else {
                k = k + 1;
                intKey.setKey(key);
                n = intKey.getHash();
                for (int i = index; i < table.length; i = i + n) {
                    head = table[i];
                    if (head == null) {
                        table[index] = chi;
                        b1 = true;
                        break;
                    }
                    k = k + 1;
                }
            }
        }

        if ((k * 100) / table.length > 10 || b1 == false) {
            int nt = table.length;
            ntl = 2 * table.length;
            for (; ; ) {
                boolean b = true;
                for (int i = 2; i <= ntl - 1; i++) {
                    if (ntl % i == 0) {
                        b = false;
                        break;
                    }
                }
                if (b == true) {
                    break;
                }
                ntl = ntl + 1;

            }
            //   System.out.println(ntl);
            table = Arrays.copyOf(table, ntl);
            if (b1 == false) {
                table[nt] = chi;
            }

        }


    }

    public V get(K key) {
        CHashItem ch;
        V value = null;
        for (int i = 0; i < table.length; i++) {
            ch = table[i];
            if (ch != null) {
                if (ch.getKey().equals(key)) {
                    value = (V) ch.getItem();
                }
            }

        }
        return value;
    }

    public void remove(K key) {
        CHashItem ch;
        V value = null;
        for (int i = 0; i < table.length; i++) {
            ch = table[i];
            if (ch != null) {
                if (ch.getKey().equals(key)) {
                    table[i] = null;
                }
            }
        }
    }

    public void change(K key1, K key2) {
        CHashItem ch;
        V value = null;
        for (int i = 0; i < table.length; i++) {
            ch = table[i];
            if (ch != null) {
                if (ch.getKey().equals(key1)) {
                    ch.setKey(key2);
                    table[i] = ch;
                }

            }
        }

    }

}

