import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int v;

    Point(int x, int v) {
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

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(x1, 1));
            points.add(new Point(x2, -1));
        }
        
        Collections.sort(points);

        int segments = 0;
        int ans = 0;
        for (Point point : points) {
            segments += point.v;
            ans = Math.max(ans, segments);
        }

        System.out.print(ans);
    }
}