import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long right = 10_000_000_000L; // 10^10
        long left = 1;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (f(mid) <= s) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    public static long f(long x) {
        return (x * (x + 1)) / 2;
    }
}