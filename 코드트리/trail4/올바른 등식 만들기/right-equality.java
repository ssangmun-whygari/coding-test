import java.util.*;
public class Main {
    public static int OFFSET = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        
        // dp[x][y] : x번째(0-based) 숫자까지 계산했을 때 합이 y인 가짓수
        long[][] dp = new long[N][41];
        dp[0][numbers[0] + OFFSET] = 1L;
        if (dp[0][numbers[0] * -1 + OFFSET] == 0) {
            dp[0][numbers[0] * -1 + OFFSET] = 1L;
        } else {
            dp[0][numbers[0] * -1 + OFFSET] += 1L;
        }

        for (int x = 0; x < N - 1; x++) {
            for (int y = 0; y <= 40; y++) {
                // dp[x][y] -> dp[x + 1][y + numbers[x + 1]]
                // dp[x][y] -> dp[x + 1][y - numbers[x + 1]]
                if (dp[x][y] != 0 && inRange(y + numbers[x + 1])) {
                    if (dp[x + 1][y + numbers[x + 1]] == 0) {
                        dp[x + 1][y + numbers[x + 1]] = 0;
                    }
                    dp[x + 1][y + numbers[x + 1]] += dp[x][y];
                }
                if (dp[x][y] != 0 && inRange(y - numbers[x + 1])) {
                    if (dp[x + 1][y - numbers[x + 1]] == 0) {
                        dp[x + 1][y - numbers[x + 1]] = 0;
                    }
                    dp[x + 1][y - numbers[x + 1]] += dp[x][y];
                }
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         if (dp[i][j] == Long.MIN_VALUE) continue;
        //         System.out.print((j - OFFSET) + " : " + dp[i][j] + ", ");
        //     }
        //     System.out.println();
        // }

        Long ans = Long.MIN_VALUE;
        System.out.print(dp[N - 1][M + OFFSET]);

    }

    public static boolean inRange(int x) {
        return x >= 0 && x <= 40;
    }
}