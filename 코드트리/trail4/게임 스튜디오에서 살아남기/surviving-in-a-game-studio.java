import java.util.Scanner;
public class Main {
    public static int R = 1000000000 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // dp[x][y][z] : x일까지 왔을때, 
        // T를 y(0 <= y < 3)번 받았고, 
        // B를 연속으로 z(0<= z <3)번 받는 경우의 수
        int[][][] dp = new int[n + 1][3][3];

        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                dp[0][y][z] = -1;
            }
        }

        dp[1][0][0] = 1; // 1일차에 G를 받을때
        dp[1][1][0] = 1; // 1일차에 T를 받을때
        dp[1][0][1] = 1; // 1일차에 B를 받을때

        for (int x = 1; x < n; x++) {
            // G를 받을 때
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    dp[x + 1][y][0] += dp[x][y][z]; // G를 받을 때
                    dp[x + 1][y][0] %= R;
                }
            }
            // T를 받을 때
            for (int y = 0; y < 2; y++) {
                for (int z = 0; z < 3; z++) {
                    dp[x + 1][y + 1][0] += dp[x][y][z]; // G를 받을 때
                    dp[x + 1][y + 1][0] %= R;
                }
            }
            // B를 받을 때
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 2; z++) {
                    dp[x + 1][y][z + 1] += dp[x][y][z];
                    dp[x + 1][y][z + 1] %= R;
                }
            }
        }

        int ans = 0;
        for (int y =0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                ans += dp[n][y][z];
                ans %= R;
            }
        }
        System.out.print(ans);
    }
}