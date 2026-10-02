import java.util.*;

public class Main {
    public static int[][] board;
    public static boolean[][] visited;
    public static int n;
    public static int m;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                board[i][j] = sc.nextInt();
        visited = new boolean[n][m];

        // 최소값을 완전탐색한다.
        int ans = Integer.MAX_VALUE;
        for (int min = 1; min <= 500; min++) {
            int minMax = Integer.MAX_VALUE;
            // 최대값을 이분탐색한다.
            int left = min;
            int right = 500;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (is_possible(min, mid)) {
                    minMax = Math.min(mid, minMax);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (minMax != Integer.MAX_VALUE) { // minMax가 갱신된 적이 있으면
                ans = Math.min(minMax - min, ans);
            }
            // System.out.println("min : " + min + ", minMax : " + minMax);
        }
        
        System.out.print(ans);
    }

    public static boolean is_possible(int min, int max) {
        // min 이상 max 이하인 칸만 지나가는 경로가 가능한가?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
        
        if (board[0][0] < min || board[0][0] > max) {
            return false;
        }

        visited[0][0] = true;
        dfs(0, 0, min, max);

        return visited[n - 1][m - 1] == true;
    }

    public static void dfs(int x, int y, int min, int max) {
        if (visited[n - 1][m - 1] == true) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!inRange(nx, ny) || visited[nx][ny] == true) continue;
            if (board[nx][ny] >= min && board[nx][ny] <= max) {
                visited[nx][ny] = true;
                dfs(nx, ny, min, max);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void printGrid() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visited[i][j] == true ? 'T' : 'F');
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}