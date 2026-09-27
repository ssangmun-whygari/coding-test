import java.util.*;

public class Main {
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 1;
        int right = 100_000;

        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, arr)) {
                ans = Math.max(mid, ans);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    public static boolean isPossible(int k, int[] arr) {
        // m개 이상의 정수를 구할 수 있는가?
        int cnt = 0;
        for (int i : arr) {
            cnt += (i / k);
        }
        return cnt >= m;
    }
}