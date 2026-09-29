import java.util.*;

class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static boolean[][] visited;
    public static int[][] board;
    public static int[] dx = new int[] {-1, 1, 0, 0};
    public static int[] dy = new int[] {0, 0, -1, 1};
    public static Queue<Pos> queue = new ArrayDeque<>();
    public static int n;
    public static int MAX_DIFF = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        visited = new boolean[n][n];

        int left = 0;
        int right = MAX_DIFF;
        int ans = MAX_DIFF;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    public static boolean is_possible(int diff) {
        // visited 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        boolean possible = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int blocks = bfs(i, j, board, diff);
                if (blocks >= Math.round(n * n / 2.0f)) {
                    possible = true;
                }
            }
        }

        return possible;
    }

    public static int bfs(int sx, int sy, int[][] board, int maxDiff) {
        // 방문한 블록의 개수를 반환
        queue.clear();
        int cnt = 0;
        if (!visited[sx][sy]) {
            queue.add(new Pos(sx, sy));
            visited[sx][sy] = true;
            cnt++;
        }

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            int prevVal = board[cur.x][cur.y];
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (!inRange(nx, ny)) continue;
                int nextVal = board[nx][ny];
                if (canGo(nx, ny, prevVal, nextVal, maxDiff)) {
                    queue.add(new Pos(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y, int prevVal, int nextVal, int maxDiff) {
        if (Math.abs(nextVal - prevVal) > maxDiff) {
            return false;
        }
        return inRange(x, y) && visited[x][y] == false;
    }
}