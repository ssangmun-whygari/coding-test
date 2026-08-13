import java.util.*;

public class Main {
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];

        List<Integer> populations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                if (visited[i][j] == false && grid[i][j] == 1) {
                    visited[i][j] = true;
                    cnt = dfs(i, j);
                    populations.add(cnt);
                }
            }
        }
        Collections.sort(populations);

        System.out.println(populations.size());
        for (int i : populations) {
            System.out.println(i);
        }
    }

    public static int dfs(int x, int y) {
        int cnt = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!inRange(nx, ny) || grid[nx][ny] == 0 || visited[nx][ny] == true) continue;
            visited[nx][ny] = true;
            cnt += dfs(nx, ny);
        }
        return cnt;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}