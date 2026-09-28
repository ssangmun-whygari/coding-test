import java.util.*;
public class Main {
    public static long MAX_RIGHT = (long) 1e18;
    // public static long MAX_RIGHT = 10L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] start = new long[m];
        long[] end = new long[m];
        for (int i = 0; i < m; i++) {
            start[i] = sc.nextLong();
            end[i] = sc.nextLong();
        }
        Arrays.sort(start);
        Arrays.sort(end);

        long left = 0;
        long right = MAX_RIGHT;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (is_possible(mid, n, start, end)) {
                ans = Math.max(mid, ans);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);

    }

    public static boolean is_possible(long x, int n, long[] start, long[] end) {
        // 모든 두 점 사이의 거리가 x 이상이라는 제약조건이 있을 때 n개의 점을
        // 모두 선분 위에 배치가 가능한가?

        long pos = start[0]; // 맨 처음에는 첫번째 선분의 왼쪽 끝에 둔다.
        int cnt = 1, i = 0;
        while (i < start.length) {
            if (pos + x >= start[i] && pos + x <= end[i]) {
                pos = pos + x;
                cnt++;
            } else if (pos + x <= start[i]) {
                pos = start[i];
                cnt++;
            } else {
                i++;
            }
        }
        return cnt >= n;
    }
}