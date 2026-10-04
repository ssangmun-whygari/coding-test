import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        
        int[] ref = new int[n];
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            ref[i] = max;
        }
        // System.out.println(Arrays.toString(ref));

        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            maxProfit = Math.max(ref[i + 1] - prices[i], maxProfit);
        }

        System.out.print(maxProfit);
    }
}