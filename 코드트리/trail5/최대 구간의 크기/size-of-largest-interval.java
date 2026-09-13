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
        int n = sc.nextInt();

        List<Point> points = new ArrayList<Point>();

        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            points.add(new Point(i, x1, 1));
            points.add(new Point(i, x2, -1));
        }
        Collections.sort(points);

        Set<Integer> set = new HashSet<>();
        int x0 = 0;
        int ans = 0;

        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);

            if (point.v == 1) {
                if (set.isEmpty()) {
                    x0 = point.x;
                }
                set.add(point.id);
            } else {
                set.remove(point.id);
                if (set.isEmpty()) {
                    int length = point.x - x0;
                    ans = Math.max(ans, length);
                }
            }
        }

        System.out.print(ans);
    }
}