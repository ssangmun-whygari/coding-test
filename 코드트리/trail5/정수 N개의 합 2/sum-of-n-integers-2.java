import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        

        int maxVal = Integer.MIN_VALUE;
        // 1 ~ K, 2 ~ K + 1...
        for (int i = 1; i <= N; i++) {
            if (i + K - 1 > N) break;

            int cand = prefixSum[i + K - 1] - prefixSum[i - 1];
            maxVal = Math.max(maxVal, cand);
        }

        System.out.print(maxVal);
    }
}