import java.util.*;

public class Main {
    public static int N;
    public static int cnt = 0;
    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new int[N + 1]; // 0 ~ N
        Arrays.fill(memo, -1);
        memo[0] = 1;
        recur(N);
        System.out.println(memo[N]);
    }

    public static int recur(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        int cnt = 0;
        if (n - 1 >= 0) {
            cnt += recur(n - 1);
        }
        if (n - 2 >= 0) {
            cnt += recur(n - 2);
        }
        if (n - 5 >= 0) {
            cnt += recur(n - 5);
        }

        return memo[n] = (cnt % 10007);
    }
}