import java.util.Scanner;
public class Main {
    public static int MOD = 1000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] dp = new int[N + 1][10]; // 길이 : 1 ~ N, 끝 수 : 0 ~ 9
        
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < dp.length - 1; i++) {
            // 0 -> 1, 1 -> 0, 2, 2 -> 1, 3 ..., 9 -> 8
            dp[i + 1][1] += dp[i][0];
            dp[i + 1][1] %= MOD;
            for (int j = 1; j <= 8; j++) {
                dp[i + 1][j + 1] += dp[i][j];
                dp[i + 1][j + 1] %= MOD;
                dp[i + 1][j - 1] += dp[i][j];
                dp[i + 1][j - 1] %= MOD;
            }
            dp[i + 1][8] += dp[i][9];
            dp[i + 1][8] %= MOD;
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i];
            ans %= MOD;
        }
        System.out.println(ans);
    }
}