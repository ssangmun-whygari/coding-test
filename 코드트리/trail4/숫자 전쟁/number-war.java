import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // 상대 패와 내 패의 위치가 같으면 동일한 상황이다.
        // dp[i][j] : 상대방(a) 위에 있는 카드가 i, 남우(b) 위에 있는 카드가 j 위치일때 남우가 지금까지 얻은 최고 점수

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        // i = 0일떄
        for (int j = 1; j <= n; j++) {
            if (b[j - 1] < a[0]) {
                dp[0][j] = dp[0][j - 1] + b[j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    if (a[i - 1] < b[j]) dp[i][j] = dp[i - 1][j];
                } else {
                    // a쪽에서 버릴 수 있었다.
                    if (a[i - 1] < b[j]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                    }
                    // b(남주)가 버릴 수 있었다.
                    if (b[j - 1] < a[i]) {
                        dp[i][j] = Math.max(dp[i][j - 1] + b[j - 1], dp[i][j]);
                    }
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[i][n]);
        }
        for (int j = 0; j <= n; j++) {
            ans = Math.max(ans, dp[n][j]);
        }
        System.out.print(ans);

    }
}