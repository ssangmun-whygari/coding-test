import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[N][N];
        dp[0][0] = grid[0][0];
        for (int c = 1; c < N; c++)
            dp[0][c] = Math.min(dp[0][c - 1], grid[0][c]);
        for (int r = 1; r < N; r++)
            dp[r][0] = Math.min(dp[r - 1][0], grid[r][0]);

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                // dp[r][c - 1], dp[r - 1][c], grid[r][c];
                int bigger = Math.max(dp[r][c - 1], dp[r - 1][c]);
                dp[r][c] = Math.min(bigger, grid[r][c]);
            }
        }

        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.print(dp[N - 1][N - 1]);
    }
}