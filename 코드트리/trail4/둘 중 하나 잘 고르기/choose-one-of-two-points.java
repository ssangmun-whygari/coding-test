import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] red = new int[n * 2];
        int[] blue = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            red[i] = sc.nextInt();
            blue[i] = sc.nextInt();
        }

        // dp[x][y] : x(0-based)번째 줄까지 골랐고
        // 지금까지 고른 red의 개수가 y일때 카드에 적힌 정수들의 최대합
        int[][] dp = new int[2 * n][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = blue[0];
        dp[0][1] = red[0];

        for (int x = 0; x < 2*n - 1; x++) {
            // dp[x][y] + red[x + 1]-> dp[x + 1][y + 1]
            // dp[x][y] + blue[x + 1] -> dp[x + 1][y]
            for (int y = 0; y < n; y++) {
                dp[x + 1][y + 1] = Math.max(dp[x][y] + red[x + 1], dp[x + 1][y + 1]);    
            }
            for (int y = 0; y <= n; y++) {
                dp[x + 1][y] = Math.max(dp[x][y] + blue[x + 1], dp[x + 1][y]);    
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.print(dp[2*n - 1][n]);
    }
}