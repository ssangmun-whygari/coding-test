import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp[x] : 원소들의 합이 x인 부분수열의 최소 원소 개수
        int[] dp = new int[10001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 10000; j >= 1; j--) {
                // arr[i]
                if (j - arr[i] < 0) continue;
                if (dp[j - arr[i]] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.print(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}