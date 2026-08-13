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
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        
        boolean[][] visited = new boolean[n][n];
        Queue<Pos> posQ = new ArrayDeque<>();
        int targetX = -1, targetY = -1, targetVal = 0;
        while (k-- > 0) {
            initialize(visited);
            posQ.add(new Pos(r - 1, c - 1));
            visited[r - 1][c - 1] = true;
            int limit = grid[r - 1][c - 1];
            targetX = -1; targetY = -1; targetVal = 0;

            while (!posQ.isEmpty()) {
                Pos now = posQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nextX = now.x + dx[d];
                    int nextY = now.y + dy[d];
                    if (!inRange(nextX, nextY, n)) continue; // 격자를 벗어나면
                    if (visited[nextX][nextY]) continue;
                    if (grid[nextX][nextY] >= limit) continue;
                    visited[nextX][nextY] = true;
                    posQ.add(new Pos(nextX, nextY));

                    if (grid[nextX][nextY] > targetVal) {
                        targetVal = grid[nextX][nextY];
                        targetX = nextX; targetY = nextY;
                    } else if (grid[nextX][nextY] == targetVal) {
                        if (nextX < targetX) {
                            targetX = nextX; targetY = nextY; 
                        } else if (nextX == targetX && nextY < targetY) {
                            targetX = nextX; targetY = nextY;
                        }
                    }
                }
            }

            if (targetX == -1 && targetY == -1) { // 이동하지 못했음
                break;
            }

            r = targetX + 1; c = targetY + 1; // 위치로 이동
        }

        System.out.print(r + " " + c);
    }

    public static void initialize(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean inRange(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}