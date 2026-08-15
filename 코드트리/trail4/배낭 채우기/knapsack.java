import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[M];
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        // dp[x] : 보석들의 총합이 x일떄 보석들의 가치합의 최대값
        int[] dp = new int[M + 1]; // 0 ~ M;
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M; j >= 1; j--) {
                // dp[j], dp[j - w[i]]
                if (j - w[i] < 0) continue;
                if (dp[j - w[i]] == -1) continue;
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }

        int maxVal = 0;
        for (int i = 1; i <= M; i++) {
            maxVal = Math.max(dp[i], maxVal);
        }
        System.out.print(maxVal);
    }
}