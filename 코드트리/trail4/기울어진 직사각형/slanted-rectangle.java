import java.util.*;

public class Main {
    public static int maxSum = 0;
    public static int N;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                simulate(i, j);
            }
        }
        System.out.println(maxSum);
    }

    public static void simulate(int x, int y) {
        int d1 = Math.min(N - 1 - y, x);
        for (int i = 1; i <= d1; i++) {
            int sum1 = 0;
            // 올라가는 칸 수가 i로 확정됨
            // 1번 대각선(우상향)
            for (int j = 0; j < i; j++) {
                // (nx + j, ny - j)
                sum1 += grid[x - j][y + j];
            }

            int x1 = x - i;
            int y1 = y + i;

            int d2 = Math.min(y1, x1);
            for (int k = 1; k <= d2; k++) {
                // 올라가는 칸 수가 k로 확정됨
                // 2번 대각선(좌상향)
                int sum2 = 0;
                for (int l = 0; l < k; l++) {
                    sum2 += grid[x1 - l][y1 - l];
                }
                int x2 = x1 - k;
                int y2 = y1 - k;
                
                // 좌하단으로 i칸, 우하단으로 k칸만큼 이동해야 함
                int d3 = Math.min(y2, N - 1 - x2);
                if (d3 < i) {
                    continue; // 좌하단으로 i칸을 갈 수 없음
                }
                int sum3 = 0;
                for (int m = 0; m < i; m++) {
                    sum3 += grid[x2 + m][y2 - m];
                }
                int x3 = x2 + i;
                int y3 = y2 - i;

                int sum4 = 0;
                int d4 = Math.min(N - 1 - y3, N - 1 - x3);
                if (d4 < k) {
                    continue; // 우하단으로 k칸을 갈 수 없음
                }
                for (int n = 0; n < k; n++) {
                    sum4 += grid[x3 + n][y3 + n];
                }

                int sum = sum1 + sum2 + sum3 + sum4;
                if (sum > maxSum) {
                    // System.out.println("x : " + x + ", y : " + y + ", i : " + i + ", k : " + k + ", sum : " + sum);
                    maxSum = sum;
                }
            }
        }
    }
}