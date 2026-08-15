import java.util.*;

class Pos {
    public int x, y, step;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = -1;
    }

    Pos(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class Main {
    public static int N;
    public static int K;
    public static int[][] grid;
    public static Queue<Pos> posQ = new ArrayDeque<>();
    public static int r1, c1, r2, c2;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static boolean[][] visited;
    public static int ans = Integer.MAX_VALUE;
    public static List<Pos> stones;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        stones = new ArrayList<>();
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) stones.add(new Pos(i, j));
            }
        }
        r1 = sc.nextInt(); c1 = sc.nextInt(); r2 = sc.nextInt(); c2 = sc.nextInt();
        r1--; c1--; r2--; c2--;
        visited = new boolean[N][N];

        List<Integer> selected = new ArrayList<>(); // 업앨 벽의 인덱스
        bt(-1, selected);

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void bt(int lastSelected, List<Integer> selected) {
        if (selected.size() == K) {
            bfs(selected);
            return;
        }

        for (int i = lastSelected + 1; i < stones.size(); i++) {
            selected.add(i);
            bt(i, selected);
            selected.remove(selected.size() - 1);
        }
    }

    public static void bfs(List<Integer> clearStones) {
        // 벽 제거
        for (int i : clearStones) {
            Pos pos = stones.get(i);
            grid[pos.x][pos.y] = 0;
        }

        posQ.clear();
        initialize(visited);
        visited[r1][c1] = true;
        posQ.add(new Pos(r1, c1, 0));
        int reachedTime = -1;
        while (!posQ.isEmpty()) {
            Pos cur = posQ.poll();
            if (cur.x == r2 && cur.y == c2) {
                reachedTime = cur.step;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                if (!inRange(nextX, nextY)) continue;
                if (visited[nextX][nextY]) continue;
                if (grid[nextX][nextY] == 1) continue; // 벽이 있음
                visited[nextX][nextY] = true;
                posQ.add(new Pos(nextX, nextY, cur.step + 1));
            }
        }

        if (reachedTime > -1) {
            ans = Math.min(ans, reachedTime);
        }

        // 벽 복원
        for (int i : clearStones) {
            Pos pos = stones.get(i);
            grid[pos.x][pos.y] = 1;
        }
    }

    public static void initialize(boolean[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = false;
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}