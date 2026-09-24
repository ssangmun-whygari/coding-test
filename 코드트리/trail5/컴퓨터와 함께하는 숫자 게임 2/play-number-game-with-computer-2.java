import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long max = 0;
        long min = Long.MAX_VALUE;
        for (long x = a; x <= b; x++) {
            long cnt = b_search(1, m, x);
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
        }

        System.out.print(min + " " + max);
    }

    public static long b_search(long l, long r, long target) {
        long cnt = 0;
        while (l <= r) {
            cnt++;
            long mid = l + (r - l) / 2;
            if (mid == target) {
                break;
            } else if (mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return cnt;
    }
}