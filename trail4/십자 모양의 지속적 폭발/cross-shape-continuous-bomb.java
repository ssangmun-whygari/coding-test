import java.util.*;

public class Main {
    public static int[][] grid;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            int col = sc.nextInt() - 1;
            int row = 0;
            // 처음으로 0이 아닌 row를 찾는다.
            while (true) {
                if (grid[row][col] != 0) break;
                row++;
                if (row >= N) {
                    row--;
                    break;
                }
            }
            explode(row, col);
        }

        // System.out.println("grid : ");
        printGrid(grid);
    }

    public static void explode(int r, int c) {
        int range = grid[r][c];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (inBombRange(i, j, r, c, range)) {
                    grid[i][j] = 0;
                }
            }
        }
        // System.out.println("grid : ");
        // printGrid(grid);

        // 중력에 의해 떨어지는 처리
        int[][] tempGrid = new int[N][N];
        for (int col = 0; col < N; col++) {
            int tempRow = N - 1;
            for (int row = N - 1; row >= 0; row--) {
                if (grid[row][col] == 0) continue;
                tempGrid[tempRow--][col] = grid[row][col];
            }
        }
        grid = tempGrid;
        // System.out.println("grid : ");
        // printGrid(grid);
    }

    public static boolean inBombRange(int r, int c, int bombR, int bombC, int range) {
        if (r != bombR && c != bombC) return false;
        return Math.abs(r - bombR) + Math.abs(c - bombC) < range;
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}