import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt() - 1, c = sc.nextInt() - 1;
        simulate(r, c, grid);

        printGrid(grid);
    }

    public static void simulate(int r, int c, int[][] grid) {
        // 폭발 범위만큼 주변 칸을 0으로 만든다.
        int n = grid[r][c] - 1; // 1일때 0
        for (int i = r - n; i <= r + n; i++) {
            if (!inRange(i, c)) continue;
            grid[i][c] = 0;
        }
        for (int i = c - n; i <= c + n; i++) {
            if (!inRange(r, i)) continue;
            grid[r][i] = 0;
        }
        // System.out.println("1단계 후 : ");
        // printGrid(grid);

        // 열을 순회하면서 중력을 작용한다.
        int[][] temp = new int[N][N];
        for (int col = 0; col < N; col++) {
            int tempRow = N - 1;
            for (int row = N - 1; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    temp[tempRow--][col] = grid[row][col];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(temp[i], 0, grid[i], 0, N);
        }
        // System.out.println("2단계 후 : ");
        // printGrid(grid);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void printGrid(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(grid[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}