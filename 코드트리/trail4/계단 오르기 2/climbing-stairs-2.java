import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            coins[i] = sc.nextInt();
        }
        
        // dp[i][j] : i(1<=i<=N)층에 도착했고 1계단 오르는 것을 j(0<=j<=3)번 까지 했을 때 
        // 지금까지 획득한 동전의 최대 개수
        int[][] dp = new int[N + 1][3 + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= 3; j++) {
                // dp[i][j], dp[i - 1][j - 1], dp[i - 2][j - 1]
                if (j == 0) {
                    if (i >= 2) dp[i][0] = dp[i - 2][0] + coins[i];
                } else {
                    if (i >= 2) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + coins[i], dp[i - 2][j] + coins[i]);
                    } else { // j >= 1 && i == 1
                        dp[i][j] = dp[i - 1][j - 1] + coins[i];
                    }
                }
            }
        }

        // printGrid(dp);

        int ans = Integer.MIN_VALUE;
        for (int j = 0; j <= 3; j++) {
            ans = Math.max(ans, dp[N][j]);
        }
        System.out.print(ans);
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}