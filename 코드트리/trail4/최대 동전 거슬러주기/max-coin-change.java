import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int coin : coins) {
                // dp[i], dp[i - coin] + 1
                if (i - coin < 0) continue;
                if (dp[i - coin] == -1) continue;
                dp[i] = Math.max(dp[i - coin] + 1, dp[i]);
            }
        }

        System.out.print(dp[m]);
    }
}