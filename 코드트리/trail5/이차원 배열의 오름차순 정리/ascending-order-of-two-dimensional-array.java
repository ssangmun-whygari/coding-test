import java.util.Scanner;

public class Main {
    public static long n;
    public static long k;
    public static long RIGHT_MAX = 1_000_000_000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        
        long left = 1;
        long right = RIGHT_MAX;

        long ans = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(mid, ans);
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    // x가 k번째 혹은 그 뒤에 있는가?
    public static boolean isPossible(long x) {
        long rb = 0;

        for (long i = n; i >= 1; i--) {
            // n * 1, n * 2, ... n * n 숫자 중에서 x보다 작거나 같은 숫자의 개수를 구한다.
            if (i > x) continue; // i > x면 i * 1 > x라서 i * 1 ~ i * n 중 x보다 작거나 같은 숫자가 없음
            rb += Math.min(n, x / i);
        }

        return k <= rb;
    }
}