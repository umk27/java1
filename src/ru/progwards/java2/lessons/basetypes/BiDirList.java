package ru.progwards.java2.lessons.basetypes;

import java.util.*;


public class BiDirList<T> implements Iterable<T> {

    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 5};
        Integer[] in = {7, 8};
        BiDirList<Integer> list1 = BiDirList.of(a);

        // int i = 0;
        //  for (Iterator<Integer> iterator = list1.iterator(); iterator.hasNext(); ) {
        //     i = i + 1;
        //     if (i % 2 == 0) {
        //         iterator.remove();
        //     }
        //      System.out.println(iterator.next());
        //  }

        System.out.println(list1.at(4));
        System.out.println(list1.size());
        System.out.println(Arrays.toString(list1.toArray(in)));

        //   BiDirList<Integer>.ListItem<Integer> current = list1.getHead();
        //     while (current != null) {
        //        System.out.println(current.getItem());
        //       current = current.getNext();
        //  }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        Itr() {

        }

        public boolean hasNext() {
            if (ll == null) {
                if (head.getNext() != null) {
                    return true;
                } else {
                    return false;
                }
            }

            if (ll.getNext() != null) {
                return true;
            } else {
                return false;
            }
        }


        public T next() {
            if (ll == null) {
                ll = head.getNext();
            } else {
                ll = ll.getNext();
            }

            return ll.getItem();

        }

        public void remove() {
            ListItem<T> lll = ll.getPrefer();
            BiDirList.this.remove((ll.getItem()));
            ll = lll;
        }
    }

    class ListItem<T> {

        private T item;
        private ListItem<T> next;
        private ListItem<T> prefer;
        private int i;


        ListItem(T item) {
            this.item = item;
        }

        T getItem() {
            return item;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        void setNext(ListItem<T> item) {
            next = item;
        }

        void setPrefer(ListItem<T> item) {
            prefer = item;
        }

        ListItem<T> getNext() {
            return next;
        }

        ListItem<T> getPrefer() {
            return prefer;
        }


    }


    private ListItem<T> head;
    private ListItem<T> tail;
    private ListItem<T> li;
    private ListItem<T> ll;

    int i1;
    int size;

    ListItem<T> getHead() {
        return head;
    }

    ListItem<T> getTail() {
        return tail;
    }

    public ListItem<T> getListItem(int i) {
        ListItem<T> z = null;
        ListItem<T> x = head;
        while (x != null) {
            x = x.getNext();
            if (x.getI() == i) {
                z = x;
                break;
            }
        }
        return z;
    }

    public T at(int i) {
        ListItem<T> z = null;
        ListItem<T> x = head;
        while (x != null) {
            x = x.getNext();
            if (x.getI() == i) {
                z = x;
                break;
            }
        }
        return z.getItem();
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        li = new ListItem<>(item);
        if (head == null) {
            i1 = 0;
            li.setI(i1);
            size = 1;
            head = li;
            tail = li;
        } else {
            i1 = i1 + 1;
            li.setI(i1);
            size = size + 1;
            li.setPrefer(tail);
            tail.setNext(li);
            tail = li;
        }
    }

    public void addLast(T item) {
        li = new ListItem<>(item);
        if (head == null) {
            i1 = 0;
            li.setI(i1);
            size = 1;
            head = li;
            tail = li;
        } else {
            i1 = i1 + 1;
            li.setI(i1);
            size = size + 1;
            li.setNext(head);
            head.setPrefer(li);
            head = li;
        }
    }

    public void remove(T item) {
        ListItem<T> z = null;
        ListItem<T> x = head;
        while (x != null) {
            x = x.getNext();
            if (x.getItem().equals(item)) {
                z = x;
                break;
            }
        }
        if (z != null) {
            ListItem<T> z1 = z.getPrefer();
            z1.setNext(z.getNext());
            ListItem<T> z2 = z.getNext();
            z2.setPrefer(z.getPrefer());
            z.setNext(null);
            z.setPrefer(null);
            size = size - 1;
        }
    }

    public static <T> BiDirList<T> from(T[] array) {
        BiDirList<T> bdl = new BiDirList<>();
        for (T x : array) {
            bdl.addFirst(x);
        }
        return bdl;
    }

    public static <T> BiDirList<T> of(T... array) {
        BiDirList<T> bdl = new BiDirList<>();
        for (T x : array) {
            bdl.addFirst(x);
        }
        return bdl;
    }

    public T[] toArray(T[] array) {
        ListItem<T> c = head;
        for (int i = 0; c != null; i++) {
            if (i + 1 > array.length) {
                array = Arrays.copyOf(array, array.length + 1);
            }
            array[i] = c.getItem();
            c = c.getNext();
        }
        return array;
    }
}

