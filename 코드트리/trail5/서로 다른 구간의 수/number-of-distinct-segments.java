import java.util.*;

class Point implements Comparable<Point> {
    public int id; // 몇번째 선분의 점인가?
    public int x;
    public int v; // 1 or -1

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
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(i, x1, 1));
            points.add(new Point(i, x2, -1));
        }
        Collections.sort(points);

        Set<Integer> set = new HashSet<>(); // 끝점에 도달하지 않은 선분들을 추적
        int ans = 0;
        for (Point point : points) {
            if (set.isEmpty()) {
                ans++; // 새로운 구간의 시작
            }

            if (point.v == 1) {
                set.add(point.id);
            } else if (point.v == -1) {
                set.remove(point.id);
            }
        }

        System.out.print(ans);
    }
}