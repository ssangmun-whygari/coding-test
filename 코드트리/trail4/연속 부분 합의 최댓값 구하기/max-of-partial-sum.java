import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // dp[x] 부분수열의 마지막 인덱스가 x일때 최대값
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // 기존에 있던 부분수열에서 잇거나 새로 시작하거나
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        System.out.print(Arrays.stream(dp).max().orElse(0));
    }
}