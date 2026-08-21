import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] clothes = new int[N][M]; // N : 옷, M : 날짜

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            for (int j = start; j <= end; j++) {
                clothes[i][j - 1] = value;
            }
        }

        // dp[x][y] : x번째 옷을 마지막으로 입었을떄 y째 날의 만족도
        int[][] dp = new int[N][M];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i][0] > 0) {
                dp[i][0] = 0;
            }
        }
        for (int days = 1; days < dp[0].length; days++) {
            for (int i = 0; i < dp.length; i++) { // 오늘 고를 옷
                if (clothes[i][days] <= 0) continue;

                for (int j = 0; j < dp.length; j++) { // 전날 고른 옷
                    if (dp[j][days - 1] < 0) continue;
                    int happy = Math.abs(clothes[i][days] - clothes[j][days - 1]);
                    dp[i][days] = Math.max(dp[i][days], dp[j][days - 1] + happy);
                }
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i][M - 1]);
        }
        System.out.print(ans);
    }
}