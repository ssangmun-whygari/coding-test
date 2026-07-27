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

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 10001 - K; i++) {
            // [i, i + K]
            int lb = i;
            int ub = i + K;
            
            int cost = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] >= lb && arr[j] <= ub) {
                    continue;
                } else if (arr[j] < lb) {
                    cost += (lb - arr[j]);
                } else {
                    cost += (arr[j] - ub);
                }
            }
            ans = Math.min(ans, cost);
        }

        System.out.println(ans);
    }
}