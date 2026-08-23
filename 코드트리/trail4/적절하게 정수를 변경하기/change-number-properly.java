import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }
        
        // dp[x][y][z] : x 위치까지 읽었고
        // 인접한 두 원소가 다른 횟수가 y번, 마지막 요소가 z일때
        // 유사도의 최대값
        int[][][] dp = new int[N][M + 1][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j <= M; j++)
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);

        for (int z = 0; z < 4; z++) {
            if (seq[0] == z + 1) {
                dp[0][0][z] = 1;
            } else {
                dp[0][0][z] = 0;
            }
        }

        for (int x = 0; x < N - 1; x++) {
            for (int y = 0; y <= M; y++) {
                for (int z0 = 0; z0 < 4; z0++) {
                    for (int z = 0; z < 4; z++) {
                        if (z == z0) {
                            // '인접한 두 원소가 다른 횟수' y가 증가하지 않음
                            // seq[x + 1]와 z + 1을 비교
                            if (seq[x + 1] == z + 1) { // 유사도 증가
                                dp[x + 1][y][z] = Math.max(dp[x][y][z0] + 1, dp[x + 1][y][z]);
                            } else {
                                dp[x + 1][y][z] = Math.max(dp[x][y][z0], dp[x + 1][y][z]);
                            }
                        } else {
                            if (y >= M) continue;
                            // '인접한 두 원소가 다른 횟수' y가 증가함
                            if (seq[x + 1] == z + 1) { // 유사도 증가
                                dp[x + 1][y + 1][z] = Math.max(dp[x][y][z0] + 1, dp[x + 1][y + 1][z]);
                            } else {
                                dp[x + 1][y + 1][z] = Math.max(dp[x][y][z0], dp[x + 1][y + 1][z]);
                            }
                        }
                    }
                }
            }
        }

        int sim = 0;
        for (int y = 0; y <= M; y++) {
            for (int z = 0; z < 4; z++) {
                sim = Math.max(sim, dp[N - 1][y][z]);
            }
        }
        System.out.print(sim);
    }
}