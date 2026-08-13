import java.util.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(0, 0);

        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(visited[i]));
        // }

        System.out.print(visited[n-1][m-1] == true ? 1 : 0);
    }

    public static void dfs(int x, int y) {
        int[] dx = new int[] {1, 0}; // 아래, 오른쪽
        int[] dy = new int[] {0, 1};

        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) { // 격자 밖으로 벗어남
            return false;
        } else if (grid[x][y] == 0) { // 뱀이 있음
            return false;
        } else if (visited[x][y] == true) { // 이미 방문한 적이 있음
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}