import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        boolean[] dp = new boolean[10001];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 10000; j >= 1; j--) {
                // dp[j - arr[i]], dp[j]
                if (j - arr[i] < 0) continue;
                if (dp[j - arr[i]] == true) {
                    dp[j] = true;
                }
            }
        }

        System.out.print(dp[m] == true ? "Yes" : "No");
    }
}