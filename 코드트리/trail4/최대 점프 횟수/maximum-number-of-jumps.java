import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == -1) continue;

                // j에서 i까지 점프가 가능한가?
                if (arr[j] + j >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } 
            }
        }

        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}