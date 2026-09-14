import java.util.*;

class Point implements Comparable<Point> {
    public int id;
    public int x;
    public int v;

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

        List<Point> points = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(i, x1, 1));
            points.add(new Point(i, x2, -1));
        }
        Collections.sort(points);

        Set<Integer> set = new HashSet<>();
        int[] preoccupied = new int[n]; // x번 선분이 독점하고 있는 길이
        int prevX = 0;
        int _prevX = 2;
        int lengthSum = 0;
        for (Point point : points) {
            if (point.v == 1) {
                if (set.isEmpty()) {
                    prevX = point.x;
                    _prevX = point.x;
                } else if (set.size() == 1) {
                    // 추가되기 직전에 한개였다 = 그동안은 혼자 독점하고 있었다.
                    for (Integer i : set) { // 하나밖에 없음
                        preoccupied[i] += (point.x - _prevX);
                    }
                }
                set.add(point.id);
            } else {
                set.remove(point.id);
                if (set.isEmpty()) {
                    int dist = point.x - prevX;
                    lengthSum += dist;
                    // 삭제되었을 때 비었다 = 그동안은 혼자 독점하고 있었다
                    preoccupied[point.id] += (point.x - _prevX);
                } else if (set.size() == 1) {
                    _prevX = point.x;
                }
            }
        }

        // System.out.println("lengthSum : " + lengthSum);
        // System.out.println("preoccupied : " + Arrays.toString(preoccupied));
        
        int minLength = Arrays.stream(preoccupied).min().orElse(0); // 가장 손해를 안보는 길이
        System.out.print(lengthSum - minLength);
    }
}