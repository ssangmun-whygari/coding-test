import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();
        
        // dp[x][y] : x번째 생성된 수정을 잡았을 때 y번 이동한 상태, 지금 위치 z
        int[][][] dp = new int[s.length()][K + 1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        char ch = s.charAt(0);
        if (ch == 'L') {
            dp[0][0][0] = 1;
            dp[0][1][1] = 0;
        } else {
            dp[0][0][0] = 0;
            dp[0][1][1] = 1;
        }

        for (int x = 0; x < dp.length - 1; x++) {
            for (int y = 0; y <= K; y++) {
                ch = s.charAt(x + 1);
                if (ch == 'L') {
                    // 이동함
                    if (y + 1 <= K) {
                        dp[x + 1][y + 1][0] = Math.max(dp[x + 1][y + 1][0], dp[x][y][1] + 1);
                        dp[x + 1][y + 1][1] = Math.max(dp[x + 1][y + 1][1], dp[x][y][0]);
                    }
                    // 그대로 있음
                    dp[x + 1][y][0] = Math.max(dp[x + 1][y][0], dp[x][y][0] + 1);
                    dp[x + 1][y][1] = Math.max(dp[x + 1][y][1], dp[x][y][1]);
                } else {
                    if (y + 1 <= K) {
                        dp[x + 1][y + 1][0] = Math.max(dp[x + 1][y + 1][0], dp[x][y][1]);
                        dp[x + 1][y + 1][1] = Math.max(dp[x + 1][y + 1][1], dp[x][y][0] + 1);
                    }
                    dp[x + 1][y][0] = Math.max(dp[x + 1][y][0], dp[x][y][0]);
                    dp[x + 1][y][1] = Math.max(dp[x + 1][y][1], dp[x][y][1] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= 1; j++) {
                // System.out.println(dp[N - 1][i][j]);
                ans = Math.max(ans, dp[N - 1][i][j]);
            }
        }
        System.out.print(ans);
    }
}