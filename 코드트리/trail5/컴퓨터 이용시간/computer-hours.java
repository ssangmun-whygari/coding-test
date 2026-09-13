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

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(i + 1, sc.nextInt(), 1));
            points.add(new Point(i + 1, sc.nextInt(), -1));
        }
        Collections.sort(points);

        PriorityQueue<Integer> seats = new PriorityQueue<>(); // 남은 자리
        for (int i = 1; i <= n; i++) {
            seats.add(i);
        }
        
        int[] seatOfp = new int[n + 1]; // seatOfp[x] : x번 사람이 점유하고 있던 좌석 번호

        for (Point point : points) {
            if (point.v == 1) {
                int seatNo = seats.poll();
                seatOfp[point.id] = seatNo;
                // System.out.println("id : " + point.id + ", seatNo : " + seatNo);
            } else {
                seats.add(seatOfp[point.id]); // 자리 반납
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(seatOfp[i] + " ");
        }
        System.out.print(sb.toString());
    }
}