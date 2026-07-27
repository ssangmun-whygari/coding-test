import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i += 2) {
            for (int j = 0; j <= 100; j += 2) {
                // x = i, y = j에 대해서 네 구역의 점을 센다
                int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
                for (int k = 0; k < N; k++) {
                    if (i < x[k] && j < y[k]) {
                        q1++;
                    } else if (i < x[k] && y[k] < j) {
                        q2++;
                    } else if (x[k] < i && y[k] < j) {
                        q3++;
                    } else {
                        q4++;
                    }
                }
                int M = Math.max(Math.max(q1, q2), Math.max(q3, q4));
                ans = Math.min(ans, M);
            }
        }

        System.out.println(ans);
    }
}