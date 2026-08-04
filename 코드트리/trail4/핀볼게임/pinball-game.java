import java.util.*;

public class Main {
    public static int ans = 0;
    public static int N;
    public static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        List<int[]> start = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            start.add(new int[] {i, 0, 0}); // 오른쪽 방향
            start.add(new int[] {N + 1, i, 1}); // 위쪽 방향
            start.add(new int[] {i, N + 1, 2}); // 왼쪽 방향
            start.add(new int[] {0, i, 3}); // 아래쪽 방향
        }

        for (int[] point : start) {
            simulate(point[0], point[1], point[2]);
        }

        System.out.println(ans);
    }

    public static void simulate(int x, int y, int dir) {
        int[] dx = new int[] {0, -1, 0, 1}; // R, U, L, D
        int[] dy = new int[] {1, 0, -1, 0};
        int t = 0;
        while (true) {
            t++;
            int nextX = dx[dir] + x;
            int nextY = dy[dir] + y;

            if (!inRange(nextX, nextY)) {
                break;
            }

            // 1 : /, 2 : \
            if (grid[nextX][nextY] == 1) {
                dir = dir ^ 1;
            } else if (grid[nextX][nextY] == 2) {
                dir = 3 - dir;
            }

            x = nextX; y = nextY;
        }
        ans = Math.max(t, ans);
    }

    public static boolean inRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}