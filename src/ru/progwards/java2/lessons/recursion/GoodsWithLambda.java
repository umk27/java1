import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class GoodsWithLambda {
    public static void main(String[] args) {

        GoodsWithLambda gwl = new GoodsWithLambda();
        gwl.setGoods(List.of(new Goods("Холодильник", "aab", 10, 55.5, Instant.ofEpochSecond(500)),
                new Goods("Телевизор", "aaa", 7, 55.5, Instant.ofEpochSecond(400)),
                new Goods("Пылесос", "baa", 25, 31.4, Instant.ofEpochSecond(700))));
        // gwl.sortByName();
        // gwl.sortByNumber();
        // gwl.sortByPartNumber();
        // gwl.expiredAfter(Instant.ofEpochSecond(550));
        // gwl.сountLess(15);
        gwl.сountBetween(8, 15);
    }

    public List<Goods> list = new ArrayList();

    public void setGoods(List<Goods> list) {
        this.list = list;
    }

    public List<Goods> sortByName() {
        List<Goods> list1 = new ArrayList<>(list);
        list1.sort(Comparator.comparing(a -> a.name));
        list1.forEach(x -> System.out.println(x.name));
        return list1;

    }

    public List<Goods> sortByNumber() {
        List<Goods> list1 = new ArrayList<>(list);
        list1.sort(Comparator.comparing(a -> a.number.toLowerCase()));
        list1.forEach(x -> System.out.println(x.name));
        return list1;

    }

    public List<Goods> sortByPartNumber() {
        List<Goods> list1 = new ArrayList<>(list);
        list1.sort(Comparator.comparing(a -> a.number.toLowerCase().substring(0, 3)));
        list1.forEach(x -> System.out.println(x.number));
        return list1;

    }

    public List<Goods> sortByAvailabilityAndNumber() {
        List<Goods> list1 = new ArrayList<>(list);
        Comparator<Goods> com = (a, b) -> {
            int i;
            if (a.price < b.price) i = 1;
            else if (b.price > a.price) i = -1;
            else if (a.number.toLowerCase().compareTo(b.number.toLowerCase()) > 0) i = 1;
            else i = -1;
            return i;
        };
        list1.sort(com);
        list1.forEach(x -> System.out.println(x.name));
        return list1;
    }

    public List<Goods> expiredAfter(Instant date) {
        List<Goods> list1 = new ArrayList<>();
        Consumer<Goods> con = a -> {
            Duration d = Duration.between(a.expired, date);
            if (d.toMillis() > 0) list1.add(a);
        };
        list.forEach(con);
        list1.sort(Comparator.comparing(a -> a.expired));
        list1.forEach(x -> System.out.println(x.name));
        return list1;
    }

    public List<Goods> сountLess(int count) {
        List<Goods> list1 = new ArrayList<>();
        Consumer<Goods> con = a -> {
            if (a.available < count) list1.add(a);
        };
        list.forEach(con);
        list1.sort(Comparator.comparing(a -> a.available));
        list1.forEach(x -> System.out.println(x.name));
        return list1;
    }

    public List<Goods> сountBetween(int count1, int count2) {
        List<Goods> list1 = new ArrayList<>();
        Consumer<Goods> con = a -> {
            if (a.available > count1 && a.available < count2) list1.add(a);
        };
        list.forEach(con);
        list1.sort(Comparator.comparing(a -> a.available));
        list1.forEach(x -> System.out.println(x.name));
        return list1;
    }
}
