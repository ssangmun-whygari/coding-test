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
        for (int r = 1; r < N; r++)
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        for (int c = 1; c < N; c++)
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        
        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                dp[r][c] = Math.max(dp[r - 1][c] + grid[r][c], dp[r][c - 1] + grid[r][c]); 
            }
        }

        // printGrid(dp);
        System.out.println(dp[N - 1][N - 1]);
    }

    public static void printGrid(int[][] grid) {
        System.out.println("grid : ");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}