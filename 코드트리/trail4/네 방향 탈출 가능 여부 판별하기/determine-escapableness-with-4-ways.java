import java.util.*;

class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[][] grid;
    public static boolean[][] visited;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        visited = new boolean[n][m];

        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        
        Queue<Pos> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.add(new Pos(0, 0));
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];
                if (!inRange(nextX, nextY)) continue;
                if (visited[nextX][nextY]) continue;
                if (grid[nextX][nextY] == 0) continue; // 뱀이 있으면 방문 못함
                visited[nextX][nextY] = true;
                queue.add(new Pos(nextX, nextY));
            }
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(visited[i]));
        // }

        System.out.print(visited[n - 1][m - 1] == true ? 1 : 0);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}