import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), H = sc.nextInt(), T = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= N - T; i++) {
            int cost = 0;
            for (int j = i; j < i + T; j++) {
                cost += Math.abs(arr[j] - H);
            }
            minCost = Math.min(cost, minCost);
        }

        System.out.println(minCost);
    }
}