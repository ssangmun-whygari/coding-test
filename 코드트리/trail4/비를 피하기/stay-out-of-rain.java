import java.util.*;

class Cell {
    public int x, y, step;
    Cell(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class Main {
    public static int N;
    public static int[][] step;
    public static int[][] grid;
    public static Queue<Cell> queue = new ArrayDeque<>();
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int[][] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int H = sc.nextInt();
        int M = sc.nextInt();
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        step = new int[N][N];
        ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    goNearShelter(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void goNearShelter(int x, int y) {
        initialize(step);
        queue.clear();

        queue.add(new Cell(x, y, 0));
        step[x][y] = 0;
        boolean reached = false;
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            if (grid[cur.x][cur.y] == 3) { // 피난처에 도착했으면
                ans[x][y] = cur.step;
                reached = true;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                if (!inRange(nextX, nextY)) continue;
                if (step[nextX][nextY] >= 0) continue; // 방문한 적이 있으면 더 방문하지 않는다.
                if (grid[nextX][nextY] == 1) continue; // 벽이면 이동할 수 없다.
                step[nextX][nextY] = cur.step + 1;
                queue.add(new Cell(nextX, nextY, cur.step + 1));
            }
        }

        if (!reached) {
            ans[x][y] = -1;
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void initialize(int[][] step) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                step[i][j] = -1;
            }
        }
    }
}