import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int v; // 1 or -1

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
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        List<Point> points = new ArrayList<>();
        int pos = 0;
        for (int i = 0; i < N; i++) {
            int dist = sc.nextInt();
            int v = sc.next().charAt(0) == 'R' ? 1 : -1;
            if (v == 1) {
                // pos, pos + dist * v
                points.add(new Point(pos, 1));
                points.add(new Point(pos + dist * v, -1));
            } else {
                points.add(new Point(pos + dist * v, 1));
                points.add(new Point(pos, -1));
            }
            pos += dist * v;
        }
        Collections.sort(points);

        Point prev = null;
        int segNum = 0;
        long ans = 0;
        for (Point point : points) {
            if (segNum >= K) {
                ans = ans + (point.x - prev.x);
            }

            if (point.v == 1) {
                segNum++;
            } else if (point.v == -1) {
                segNum--;
            }

            prev = point;
        }

        System.out.print(ans);
    }
}