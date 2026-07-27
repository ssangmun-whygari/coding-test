import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[100001]; // 1 ~ 10000
        for (int i = 0; i < N; i++) {
            int pos = sc.nextInt();
            char alphabet = sc.next().charAt(0);
            arr[pos] = (alphabet == 'G') ? 1 : 2;
        }

        int maxSum = 0;
        for (int i = 1; i <= 10000 - K; i++) {
            int cand = 0;
            for (int j = i; j <= i + K; j++) {
                cand += arr[j];
            }
            maxSum = Math.max(maxSum, cand);
        }

        System.out.println(maxSum);
    }
}