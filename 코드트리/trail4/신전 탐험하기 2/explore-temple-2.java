import java.util.*;
public class Main {
    public static int[][] temple;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        temple = new int[n][3];
        for (int i = 0; i < n; i++) {
            temple[i][0] = sc.nextInt();
            temple[i][1] = sc.nextInt();
            temple[i][2] = sc.nextInt();
        }
        
        int[][] dp = new int[n][3];

        int ans = 0;
        for (int i = 0; i <= 2; i++) {
            run(dp, i);
            for (int j = 0; j <= 2; j++) {
                if (i == j) continue;
                ans = Math.max(ans, dp[n - 1][j]);
            }
        }
        System.out.print(ans);
    }

    public static void run(int[][] dp, int i) {
        for (int j = 0; j < dp.length; j++)
            Arrays.fill(dp[j], Integer.MIN_VALUE);

        // 첫번째에 i번째 방을 방문함
        dp[0][i] = temple[0][i];

        for (int j = 0; j < dp.length - 1; j++) {
            for (int k = 0; k <= 2; k++) {
                for (int l = 0; l <= 2; l++) {
                    if (k == l) continue;
                    dp[j + 1][k] = Math.max(dp[j][l] + temple[j + 1][k], dp[j + 1][k]);
                }
            }
        }
    }
}