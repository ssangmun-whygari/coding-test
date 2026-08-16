import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        // dp[x] : 총 x의 길이로 얻을 수 있는 최대수익
        int[] dp = new int[N + 1]; // 1 ~ N;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] + arr[i - j]
                dp[i] = Math.max(dp[j] + arr[i - j], dp[i]);
            }
        }

        System.out.print(dp[N]);
    }
}