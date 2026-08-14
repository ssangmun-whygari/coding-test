import java.util.*;

class Cell {
    public int x, y, step;
    Cell (int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class Main {
    public static int[][] step;
    public static int[][] grid;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        step = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(step[i], -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt(); // 뱀이 있으면 0
            }
        }

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(0, 0, 0));
        step[0][0] = 0;

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                if (!inRange(nextX, nextY)) continue;
                if (step[nextX][nextY] >= 0) continue;
                if (grid[nextX][nextY] == 0) continue;

                step[nextX][nextY] = cur.step + 1;
                queue.add(new Cell(nextX, nextY, cur.step + 1));
            }
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         System.out.print(step[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(step[N - 1][M - 1]);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}