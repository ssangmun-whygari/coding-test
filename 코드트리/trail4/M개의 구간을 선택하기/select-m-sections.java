import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp[x][y] - x: x번째(1-based)까지 고려, y : 지금까지 선택한 구간들의 개수
        // z : x번째 숫자를 선택함 여부(1 : 선택, 0 : 선택 안함)
        int[][][] dp = new int[n + 1][m + 1][2];

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                Arrays.fill(dp[i][j], -1000 * 500);
        
        dp[1][1][1] = arr[1]; dp[1][0][0] = 0;
        for (int x = 1; x < n; x++) {
            for (int y = 0; y <= m; y++) {
                // dp[x][y][0] + arr[x + 1]-> dp[x + 1][y + 1][1]
                if (y < m) {
                    dp[x + 1][y + 1][1] = Math.max(dp[x][y][0] + arr[x + 1], dp[x + 1][y + 1][1]);
                }
                // dp[x][y][0] -> dp[x + 1][y][0]. dp[x][y][1] -> dp[x + 1][y][0]
                dp[x + 1][y][0] = Math.max(dp[x][y][0], dp[x][y][1]);
                // dp[x][y][1] + arr[x + 1] -> dp[x + 1][y][1]
                dp[x + 1][y][1] = Math.max(dp[x + 1][y][1], dp[x][y][1] + arr[x + 1]);                
            }
        }

        // printGrid(dp);

        int ans = Integer.MIN_VALUE;
        ans = Math.max(dp[n][m][0], dp[n][m][1]);
        System.out.print(ans);
    }

    public static void printGrid(int[][][] grid) {
        for (int i = 1; i < grid.length; i++) {
            System.out.print("(x : " + i + ") ");
            for (int j = 1; j < grid[0].length; j++) {
                System.out.print(Arrays.toString(grid[i][j]) + ", ");
            }
            System.out.println();
        }
    }
}