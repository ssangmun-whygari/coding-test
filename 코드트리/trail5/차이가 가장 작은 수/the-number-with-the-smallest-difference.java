import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int i : set) {
            Integer high = set.ceiling(i + m);
            Integer low = set.floor(i - m);
            if (high != null) {
                ans = Math.min(high - i, ans);
            }
            if (low != null) {
                ans = Math.min(i - low, ans);
            }
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}