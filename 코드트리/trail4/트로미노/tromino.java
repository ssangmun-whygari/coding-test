import java.util.*;

public class Main {
    public static int[][] grid;
    public static int N;
    public static int M;
    public static int max = 0;
    public static int cand = 0;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        processShape(-1, 0, 0, -1);
        processShape(1, 0, 0, -1);
        processShape(-1, 0, 0, 1);
        processShape(1, 0, 0, 1);
        processShape(-1, 0, 1, 0);
        processShape(0, -1, 0, 1);

        System.out.println(max);
    }

    public static void processShape(int x1, int y1, int x2, int y2) {
        for (int cx = 0; cx < N; cx++) {
            for (int cy = 0; cy < M; cy++) {
                if (xInRange(cx + x1) && xInRange(cx + x2) && yInRange(cy + y1) && yInRange(cy + y2)) {
                    cand = 0;
                    cand += (grid[cx + x1][cy + y1] + grid[cx + x2][cy + y2] + grid[cx][cy]);
                    max = Math.max(cand, max);
                }
            }
        }
    }

    public static boolean xInRange(int x) {
        return x >= 0 && x < N;
    }

    
    public static boolean yInRange(int y) {
        return y >= 0 && y < M;
    }


}