import java.util.*;

public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= 10000; i++) { // 최소값
            // 범위 : i ~ i + K
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] >= i && arr[j] <= i + K) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}