import java.util.*;
public class Main {
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);

        // 가장 가까운 두 점 사이의 거리
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, points[i] - points[i - 1]);
        }

        int left = min;
        int right = 1_000_000_000;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, points)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    public static boolean isPossible(int x, int[] points) {
        // 가장 인접한 두 점 사이의 거리가 x이상이어야 한다. 이 배치가 가능한가?
        // m개의 점을 위치시켜야 한다.
        boolean possible = false;
        int cnt = 1;
        int pos = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i] - pos >= x) {
                // i에 점을 놓을 수 있다.
                cnt += 1;
                pos = points[i];
            }

            if (cnt == m) { // m개를 전부 놓았다.
                possible = true;
                break;
            }
        }

        return possible;
    }
}