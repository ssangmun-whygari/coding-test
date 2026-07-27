import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxSum = 0;
        for (int i = 0; i <= N - K; i++) {
            int cand = 0;
            for (int j = i; j < i + K; j++) {
                cand += arr[j];
            }
            maxSum = Math.max(maxSum, cand);
        }
        System.out.println(maxSum);
    }
}