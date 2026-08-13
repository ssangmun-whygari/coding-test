import java.util.*;

public class Main {
    public static int N;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int blocks;
    public static int maxBlocks = 0;
    public static int explodedBlockNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    blocks = 1;
                    dfs(grid[i][j], i, j);

                    maxBlocks = Math.max(maxBlocks, blocks);
                    if (blocks >= 4) {
                        explodedBlockNum++;
                    }
                }
            }
        }

        System.out.print(explodedBlockNum + " " + maxBlocks);
    }

    public static void dfs(int val, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!inRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (grid[nx][ny] == val) { // 다음 칸이 같은 값을 가지고 있으면
                visited[nx][ny] = true;
                blocks += 1;
                dfs(val, nx, ny);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}