import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j <= 100; j++) {
            // 20 -> 0 ~ 17
            // 4 -> 0 ~ 17
            // 1 -> 0 ~ 17
            int cost = 0;
            for (int k = 0; k < N; k++) {
                int subject = arr[k];
                int minDiff = Integer.MAX_VALUE;
                // 배열 안의 어떤 요소에 대해 최소값을 구한다
                for (int m = j; m <= j + 17; m++) {
                    int diff = Math.abs(subject - m);
                    minDiff = Math.min(minDiff, diff);
                }
                cost += (minDiff * minDiff);
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
    }
}