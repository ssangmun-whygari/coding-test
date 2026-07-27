import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[101]; // 0 ~ 100
        for (int i = 0; i < N; i++) {
            int amount = sc.nextInt();
            int pos = sc.nextInt();
            arr[pos] += amount;
        }
        
        int maxSum = 0;
        for (int c = 0; c <= 100; c++) {
            // [c - K ~ c + K]
            int lb = Math.max(0, c - K);
            int ub = Math.min(100, c + K);
            int sum = 0;
            for (int i = lb; i <= ub; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(sum, maxSum);
        }

        System.out.println(maxSum);
    }
}