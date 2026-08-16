import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int M = Arrays.stream(arr).sum();
        boolean[] dp = new boolean[M + 1];

        // arr에 있는 원소들 중 최대 1개만 골라서 x를 만들 수 있는가?
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = M; j >= 1; j--) {
                if (j - arr[i] < 0) continue;
                if (dp[j - arr[i]] == true) {
                    dp[j] = true;
                }
            }
        }

        int ans = M;
        for (int i = 1; i <= M; i++) {
            if (dp[i] == true) {
                int diff = Math.abs(i - (M - i));
                ans = Math.min(diff, ans);
            }
        }
        System.out.print(ans);
    }
}