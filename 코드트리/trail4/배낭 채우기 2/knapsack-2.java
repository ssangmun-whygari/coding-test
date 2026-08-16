import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        
        // dp[x][y] : x번째 보석까지만 이용 가능하고 무게 총합이 y일때 최대 가치
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        // for (int i = 0; i <= m; i++)
        //     dp[0][i] = 0;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        // printGrid(dp);
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // i번째 보석을 몇개까지 넣을 수 있나?
                // weight[i] * k <= m 이어야 함
                int k = 0;
                while (weight[i] * k <= m) {
                    if (j - weight[i] * k < 0) {
                      k++;
                      continue;
                    }
                    if (dp[i - 1][j - weight[i] * k] == -1) {
                      k++;
                      continue;
                    } 
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i] * k] + (value[i] * k));
                    k++;
                }
            }
            // System.out.println("i : " + i);
            // printGrid(dp);
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= m; j++) {
            ans = Math.max(dp[i][j], ans);
          }
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