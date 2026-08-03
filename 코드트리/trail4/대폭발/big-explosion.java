import java.util.*;

public class Main {
    public static int N;
    public static int[][] grid;
    public static int[][] nextGrid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        grid = new int[N][N];
        grid[r][c] = 1;
        nextGrid = new int[N][N];

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, -1, 0, 1};

        int range = 1;
        while (T-- > 0) {
            copyGrid(grid, nextGrid); // grid -> nextGrid

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 0) continue;
                    for (int d = 0; d < 4; d++) {
                        // (range * dx[d] + i, range * dy[d] + j)
                        int newX = range * dx[d] + i;
                        int newY = range * dy[d] + j;
                        if (!inRange(newX, newY)) continue;
                        nextGrid[newX][newY] = 1;
                    }
                }
            }

            copyGrid(nextGrid, grid); // nextGrid -> grid
            // printGrid(grid);
            range *= 2;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void printGrid(int[][] grid) {
        System.out.println("grid : ");
        for (int i = 0; i < N; i++)
            System.out.println(Arrays.toString(grid[i]));
    }

    public static void copyGrid(int[][] src, int[][] dest) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }
}