import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();

        long left = 1L;
        long right = 100_000_000_000_000L;
        long ans = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (is_possible(mid, n, arr)) {
                // 더 짧은 시간이 있는가?
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }

    public static boolean is_possible(long x, int n, int[] arr) {
        // x 시간 내에 n개의 물건을 모두 통과시킬 수 있는가?
        long cnt = 0;
        for (int funnel : arr) {
            cnt += (x / funnel);
        }
        return cnt >= n;
    }
}