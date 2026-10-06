import java.util.*;

public class Main {
    public static int[] dx = new int[] {-1, 0, 0, 1}; // U, L, R, D
    public static int[] dy = new int[] {0, -1, 1, 0};
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int cnt = 0;
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (arr[r - 1][c] == 0) {
                    // (r, c)를 눌러야 함
                    invert(arr, r, c);
                    cnt++;
                }
            }
        }

        boolean possible = true;
        for (int c = 0; c < n; c++) {
            if (arr[n - 1][c] == 0) {
                possible = false;
            }
        }

        System.out.print(possible ? cnt : -1);
    }

    public static void invert(int[][] grid, int r, int c) {
        grid[r][c] = (1 - grid[r][c]);
        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];
            if (inRange(nr, nc)) {
                grid[nr][nc] = 1 - grid[nr][nc];
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}