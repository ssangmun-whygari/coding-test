import java.util.*;

public class Main {
    public static int[] arr;
    public static int[] prefixSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();
        int[] nums = new int[b];
        for (int i = 0; i < b; i++) {
            nums[i] = sc.nextInt();
        }

        arr = new int[n + 1]; // x가 없으면 arr[x] = 0, x가 있으면 arr[x] = 1;
        Arrays.fill(arr, 1);
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = 0;
        }

        prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 예)
        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        // X, X, O, O, X, O, O. O, X, X

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k + 1; i++) {
            // i ~ i + k - 1 구간에서 arr 요소 합을 구한다.
            int num = getSum(i, i + k - 1);
            ans = Math.min(ans, k - num);
        }

        System.out.print(ans);
    }

    public static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }
}