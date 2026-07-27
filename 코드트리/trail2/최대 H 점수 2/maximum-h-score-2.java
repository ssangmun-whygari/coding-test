import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int ans = -1;
        // 배열 요소 개수가 n개라서 H는 무조건 n 이하이다.
        for (int i = 0; i <= N; i++) {
            int cnt = 0;
            int chance = L;
            for (int j = 0; j < N; j++) {
                if (arr[j] >= i) {
                    cnt++;
                } else if (arr[j] == i - 1) { // 목표값보다 1만큼 작으면
                    if (chance > 0) {
                        chance--;
                        cnt++;
                    }
                }
            }
            // System.out.println("i : " + i + ", chance : " + chance + ", cnt : " + cnt);
            if (cnt >= i) {
                ans = Math.max(ans, i);
            }
        }

        System.out.println(ans);
    }
}