import java.util.*;

class Pair implements Comparable<Pair> {
    public int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        } else {
            return Integer.compare(this.x, other.x);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int[] qx = new int[m];
        int[] qy = new int[m];
        for (int i = 0; i < m; i++) {
            qx[i] = sc.nextInt();
            qy[i] = sc.nextInt();
        }

        TreeSet<Pair> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(new Pair(x[i], y[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            // qx[i], qy[i]
            Pair dot = set.ceiling(new Pair(qx[i], qy[i]));
            if (dot == null) {
                sb.append("-1 -1");
            } else {
                sb.append(dot.x + " " + dot.y);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}