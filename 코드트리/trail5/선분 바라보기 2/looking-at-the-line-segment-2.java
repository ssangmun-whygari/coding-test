import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    public int x;
    public int y;
    public int v;
    public int id;

    Point(int id, int x, int y, int v) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.v = v;
    }

    @Override
    public int compareTo(Point other) {
        return Integer.compare(this.x, other.x);
    }
    
    @Override
    public String toString() {
        return "[id : " + id + ", y : " + y + ", x : " + x + " v : " + v + "]";
    }
}

class Point2 {
    public int id;
    public int y;

    Point2(int id, int y) {
        this.id = id;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2)) return false;
        Point2 other = (Point2) o;
        return this.id == other.id && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.y);
    }

    @Override
    public String toString() {
        return "[id : " + id + ", y : " + y + "]";
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            points.add(new Point(i, x1, y, 1));
            points.add(new Point(i, x2, y, -1));
        }
        Collections.sort(points);

        // y값이 가장 작은 점부터 빠져나옴
        PriorityQueue<Point2> pq = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p1.y, p2.y)
        );
        Set<Integer> set = new HashSet<>();

        for (Point point : points) {
            if (point.v == 1) {
                pq.add(new Point2(point.id, point.y));
                set.add(pq.peek().id); // y값이 가장 작은 선분의 id
            } else {
                pq.remove(new Point2(point.id, point.y));
                if (!pq.isEmpty()) {
                    set.add(pq.peek().id);
                }
            }
        }

        System.out.print(set.size());
    }
}