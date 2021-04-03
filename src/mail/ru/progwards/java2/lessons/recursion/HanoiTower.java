import java.util.*;

public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower(3, 1);
        hanoiTower.move(2, 2);
    }

    int size;
    int pos;

    static int i = 0;
    static HashMap<Integer, Integer> m = new HashMap<>();

    public HanoiTower(int size, int pos) {
        this.size = size;
        this.pos = pos;
    }

    public void move(int from, int to) {
        if (i == 0) {

            if (from != pos || from == to) {
                return;
            }
            m.put(pos, size);
            m.put(to, 0);
            for (int j = 1; j < m.size() + 1; j++) {
                if (!m.containsKey(j)) m.put(j, 0);
            }

        }
        i = i + 1;
        m.put(from, m.get(from) - 1);
        m.put(to, m.get(to) + 1);
        if (to != 3) {
            m.put(to + 1, m.get(to + 1) + 1);
        //    move();
        } else {
            m.put(1, m.get(1) + 1);
        }
     //   move();
    }
}
