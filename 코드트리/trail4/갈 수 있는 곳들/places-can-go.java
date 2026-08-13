import java.util.*;

class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        List<Pos> starts = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            starts.add(new Pos(sc.nextInt() - 1, sc.nextInt() - 1));
        }

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        boolean[][] visited = new boolean[N][N];
        int ans = 0;
        for (Pos start : starts) {

            if (visited[start.x][start.y]) continue;

            Queue<Pos> queue = new ArrayDeque<>();
            visited[start.x][start.y] = true;
            queue.add(start);
            int cells = 1;

            while (!queue.isEmpty()) {
                Pos now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nextX = now.x + dx[d];
                    int nextY = now.y + dy[d];
                    if (!inRange(nextX, nextY, N)) continue;
                    if (grid[nextX][nextY] == 1) continue;
                    if (visited[nextX][nextY]) continue;
                    visited[nextX][nextY] = true;
                    cells += 1;
                    queue.add(new Pos(nextX, nextY));
                }
            }

            ans += cells;
        }

        System.out.println(ans);
    }

    public static boolean inRange(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}