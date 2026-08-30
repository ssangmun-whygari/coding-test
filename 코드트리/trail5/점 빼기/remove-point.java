import java.util.*;

class Pair implements Comparable<Pair> {
    public int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        TreeSet<Pair> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            set.add(new Pair(x, y));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int query = sc.nextInt();

            Pair pair = new Pair(query, Integer.MIN_VALUE);
            Pair target = set.ceiling(pair);
            if (target != null) {
                sb.append(target.x + " " + target.y);
                set.remove(target);
            } else {
                sb.append("-1 -1");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}