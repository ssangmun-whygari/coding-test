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
    public static int n;
    public static int[][] step;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;
        
        step = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(step[i], -1);
        step[r1][c1] = 0;

        int[] dx = new int[] {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dy = new int[] {-1, 1, 2, 2, 1, -1, -2, -2};

        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(r1, c1, 0));
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                if (canGo(nextX, nextY)) {
                    step[nextX][nextY] = cur.step + 1;
                    queue.add(new Cell(nextX, nextY, cur.step + 1));
                }
            }
        }

        System.out.println(step[r2][c2]);
    }

    public static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        } else if (step[x][y] >= 0) { // 재방문시
            return false;
        }
        return true;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}