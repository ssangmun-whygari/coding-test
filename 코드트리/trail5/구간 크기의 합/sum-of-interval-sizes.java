import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int v;
    public int id;
    
    Point(int id, int x, int v) {
        this.id = id;
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.x, other.x);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n * 2];
        for (int i = 0; i < n; i++) {
            int x0 = sc.nextInt();
            int x1 = sc.nextInt();
            points[2 * i] = new Point(i, x0, 1);
            points[2 * i + 1] = new Point(i, x1, -1);
        }
        Arrays.sort(points);

        Set<Integer> set = new HashSet<>();
        long ans = 0;
        int x0 = 0;
        for (int i = 0; i < points.length; i++) {
            int id = points[i].id;
            int v = points[i].v;
            int x = points[i].x;

            if (set.isEmpty()) {
                x0 = x;
            }

            if (v == 1) {
                set.add(id);
            } else {
                set.remove(id);
                if (set.isEmpty()) {
                    ans += (x - x0);
                }
            }
        }

        System.out.print(ans);
    }
}