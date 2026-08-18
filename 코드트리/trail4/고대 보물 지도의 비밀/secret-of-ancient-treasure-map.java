import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[][] dp = new int[N][K + 1];
        for (int x = 0; x < N; x++)
            Arrays.fill(dp[x], Integer.MIN_VALUE);
        // dp[x][y] : x번쨰 수를 마지막으로 밟음, 그동안 밟은 음수 개수가 y
        if (arr[0] >= 0) {
            dp[0][0] = arr[0];
        } else {
            dp[0][1] = arr[0];
        }

        for (int x = 0; x < N - 1; x++) {
            for (int y = 0; y <= K; y++) {
                if (arr[x + 1] >= 0) { // 다음에 밟을 수가 양수
                    if (dp[x][y] != Integer.MIN_VALUE) {
                        dp[x + 1][y] = Math.max(dp[x + 1][y], dp[x][y] + arr[x + 1]); // 연속해서 밟는다.
                    }
                    dp[x + 1][0] = Math.max(dp[x + 1][0], arr[x + 1]); // 다 버리고 새로 밟는다.
                } else { // 다음에 밟을 수가 음수
                    if (y < K) { // 아직 음수를 밟을 수 있으면
                        if (dp[x][y] != Integer.MIN_VALUE) {
                            dp[x + 1][y + 1] = Math.max(dp[x + 1][y + 1], dp[x][y] + arr[x + 1]); // 연속해서 밟는다.
                        }
                        dp[x + 1][1] = Math.max(dp[x + 1][1], arr[x + 1]); // 다 버리고 새로 밟는다.
                    }
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j <= K; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.print(ans);
    }
}