import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int[][] dp = new int[n][n];

        dp[0][n - 1] = grid[0][n - 1]; // 초기값
        for (int c = n - 2; c >= 0; c--) {
            dp[0][c] = dp[0][c + 1] + grid[0][c];
        }
        for (int r = 1; r < n; r++) {
            dp[r][n - 1] = dp[r - 1][n - 1] + grid[r][n - 1];
        }
        // printGrid("초기값", dp);

        for (int r = 1; r < n; r++) {
            for (int c = n - 2; c >= 0; c--) {
                dp[r][c] = Math.min(dp[r - 1][c] + grid[r][c], dp[r][c + 1] + grid[r][c]);
            }
        }

        System.out.println(dp[n - 1][0]);
    }

    public static void printGrid(String str, int[][] grid) {
        System.out.println(str + " : ");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}