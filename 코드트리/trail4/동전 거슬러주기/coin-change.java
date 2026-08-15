import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[M + 1]; // 0 ~ M
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= M; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                if (dp[i - coin] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.print(dp[M] == Integer.MAX_VALUE ? -1 : dp[M]);
    }
}