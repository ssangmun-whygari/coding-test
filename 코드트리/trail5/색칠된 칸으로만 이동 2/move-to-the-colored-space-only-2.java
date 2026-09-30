import java.util.*;

class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static List<Pos> coloredPos = new ArrayList<>();
    public static boolean[][] visited;
    public static int[][] board;
    public static int[] dx = new int[] {-1, 1, 0, 0};
    public static int[] dy = new int[] {0, 0, -1, 1};
    public static int m;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        int[][] colored = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colored[i][j] = sc.nextInt();
                if (colored[i][j] == 1) {
                    coloredPos.add(new Pos(i, j));
                }
            }
        }
        visited = new boolean[m][n];

        int left = 0;
        int right = (int) 1e9;
        int ans = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }

    public static boolean is_possible(int diff) {
        // visited 초기화
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        int sx = coloredPos.get(0).x;
        int sy = coloredPos.get(0).y;
        visited[sx][sy] = true;
        dfs(sx, sy, diff);

        boolean allVisited = true;
        for (Pos pos : coloredPos) {
            if (visited[pos.x][pos.y] == false) {
                allVisited = false;
                break;
            }
        }

        return allVisited;
    }

    public static void dfs(int x, int y, int diff) {
        int prevVal = board[x][y];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!inRange(nx, ny)) continue;
            if (Math.abs(board[nx][ny] - prevVal) > diff) continue;
            if (visited[nx][ny] == true) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, diff);
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}