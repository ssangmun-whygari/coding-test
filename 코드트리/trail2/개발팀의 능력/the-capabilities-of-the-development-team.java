import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int totalSum = Arrays.stream(arr).sum();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int sum1 = arr[i] + arr[j];

                for (int k = 0; k < 5; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        if (i == k || i == l || j == k || j == l) continue;
                        int sum2 = arr[k] + arr[l];
                        int sum3 = totalSum - sum1 - sum2;
                        if (sum1 == sum2 || sum1 == sum3 || sum2 == sum3) continue;
                        
                        int worst = Math.min(Math.min(sum1, sum2), sum3);
                        int best = Math.max(Math.max(sum1, sum2), sum3);

                        ans = Math.min(best - worst, ans);
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}