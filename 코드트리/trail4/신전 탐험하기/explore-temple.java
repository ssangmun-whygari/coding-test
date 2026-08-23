import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N][3];
        for (int i = 0; i < N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }
        
        int[][] dp = new int[N][3];
        dp[0][0] = data[0][0];
        dp[0][1] = data[0][1];
        dp[0][2] = data[0][2];
        
        for (int i = 0; i < N - 1; i++) {
            dp[i + 1][0] = Math.max(dp[i][1] + data[i + 1][0], dp[i][2] + data[i + 1][0]);
            dp[i + 1][1] = Math.max(dp[i][0] + data[i + 1][1], dp[i][2] + data[i + 1][1]);
            dp[i + 1][2] = Math.max(dp[i][0] + data[i + 1][2], dp[i][1] + data[i + 1][2]);
        }

        int ans = 0;
        for (int i = 0; i <= 2; i++) {
            ans = Math.max(ans, dp[N - 1][i]);
        }
        System.out.print(ans);
    }
}