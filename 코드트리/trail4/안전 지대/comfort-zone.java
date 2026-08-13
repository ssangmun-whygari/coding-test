import java.util.Scanner;
public class Main {
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int n;
    public static int m;
    public static int maxCnt = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        visited = new boolean[n][m];

        int maxK = 0, cnt = 0;
        for (int k = 1; k <= 100; k++) {
            initialize(visited);
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && grid[i][j] > k) {
                        visited[i][j] = true;
                        cnt++;
                        visitSafeArea(k, i, j);
                    }
                }
            }
            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxK = k;
            }
        }

        System.out.print(maxK + " " + maxCnt);
    }

    public static void visitSafeArea(int limit, int x, int y) {
        // limit을 초과하는 칸만 방문 가능하다

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!inRange(nx, ny)) continue;
            if (grid[nx][ny] <= limit) continue;
            if (visited[nx][ny] == true) continue;
            visited[nx][ny] = true;
            visitSafeArea(limit, nx, ny);
        }
    }

    public static void initialize(boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}