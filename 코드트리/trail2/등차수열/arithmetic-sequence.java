import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int maxCnt = 0;
        for (int n = 1; n <= 100; n++) {
            int cnt = 0;
            // (ai, aj) 쌍
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    // 등차수열 확인
                    if (n - arr[i] == arr[j] - n) cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);
    }
}