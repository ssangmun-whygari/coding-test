import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int k = info.length;
        // dp[x][y] : x번째 물건까지 훔친 후 B도둑이 남긴 흔적이 y일때 A도둑이 남긴 흔적의 최소값
        int[][] dp = new int[k][m + 1];
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 1000;
            }
        }
        
        for (int x = 0; x < k; x++) {
            if (x == 0) {
                if (info[x][1] <= m) {
                    dp[0][info[x][1]] = 0; // B가 훔침    
                }
                dp[0][0] = info[x][0]; // A가 훔침
            } else {
                for (int y = 0; y <= m; y++) {
                    // x번째에 A가 훔쳤다면?
                    dp[x][y] = Math.min(dp[x][y], dp[x - 1][y] + info[x][0]);
                    // x번쨰에 B가 훔쳤다면?
                    if (y - info[x][1] >= 0) {
                        dp[x][y] = Math.min(dp[x][y], dp[x - 1][y - info[x][1]] );
                    }
                }
            }
        }
        // printGrid(dp);
        
        int ans = 1000;
        for (int y = 0; y < m; y++) {
            if (dp[k - 1][y] < n) {
                ans = Math.min(ans, dp[k - 1][y]);
            }
        }
        return (ans == 1000) ? -1 : ans;
    }
    
    public void printGrid(int[][] grid) {
        System.out.println("grid : ");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("grid end");
    }
}