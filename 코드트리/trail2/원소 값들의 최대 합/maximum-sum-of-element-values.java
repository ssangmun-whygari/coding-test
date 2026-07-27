import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        // 5, 1, 4, 2, 3

        
        int ans = 0;
        // 시작 위치 : 1 ~ N
        for (int i = 1; i <= N; i++) {
            int idx = i;
            int sum = 0;
            // M번 움직임을 해서 idx를 이동시킨다.
            for (int j = 0; j < M; j++) {
                sum += arr[idx];
                idx = arr[idx];
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}