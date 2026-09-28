import java.util.*;

class Segment implements Comparable<Segment> {
    public int x0, x1;

    Segment(int x0, int x1) {
        this.x0 = x0;
        this.x1 = x1;
    }

    @Override
    public int compareTo(Segment other) {
        return Integer.compare(this.x0, other.x0);
    }
}

public class Main {
    public static int n;
    public static int MAX_RIGHT = (int) 1e9 - 1;
    // public static int MAX_RIGHT = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int x0 = sc.nextInt();
            int x1 = sc.nextInt();
            segments[i] = new Segment(x0, x1);
        }
        Arrays.sort(segments);

        int left = 0;
        int right = MAX_RIGHT;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid, segments)) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.print(ans);
    }

    // x 이상의 거리로 점을 배치하는 것이 가능한가?
    public static boolean is_possible(int x, Segment[] segments) {
        int pos = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (pos + x > segments[i].x1) {
                break;
            } else {
                cnt++;
                pos = Math.max(pos + x, segments[i].x0);
            }
        }
        return cnt >= n;
    }
}