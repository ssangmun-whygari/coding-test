import java.util.*;
class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static List<Pos> stones = new ArrayList<>();
    public static int[][] grid;
    public static Queue<Pos> posQ = new ArrayDeque<>();
    public static List<Pos> starts = new ArrayList<>();
    public static int M;
    public static boolean[][] visited;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        grid = new int[N][N];
        int K = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) stones.add(new Pos(i, j));
            }
        }

        for (int i = 0; i < K; i++) {
            starts.add(new Pos(sc.nextInt() - 1, sc.nextInt() - 1));
        }

        recur(0, 0);
        System.out.println(ans);
    }

    public static void recur(int nth, int cnt) {
        if (cnt == M) {
            // 치운 돌의 개수가 M개에 도달했으면
            int cells = bfs();
            ans = Math.max(ans, cells);
            return;
        } else if (nth == stones.size()) { // M개에 도달하지 못했는데 돌을 전부 봤으면
            return;
        }

        // nth번째 stones를 제거하기로 선택
        Pos stone = stones.get(nth);
        grid[stone.x][stone.y] = 0;
        recur(nth + 1, cnt + 1);
        grid[stone.x][stone.y] = 1;

        // nth번째 stones를 제거하지 않기로 선택
        recur(nth + 1, cnt);
    }

    public static int bfs() {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        initialize(visited);

        int cnt = 0;
        for (Pos start : starts) {
            if (!visited[start.x][start.y] && grid[start.x][start.y] == 0) {
                visited[start.x][start.y] = true;
                cnt += 1;
                posQ.add(start);

                while (!posQ.isEmpty()) {
                    Pos cur = posQ.poll();
                    for (int d = 0; d < 4; d++) {
                        int nextX = cur.x + dx[d];
                        int nextY = cur.y + dy[d];
                        if (!inRange(nextX, nextY, visited)) continue;
                        if (visited[nextX][nextY]) continue;
                        if (grid[nextX][nextY] == 1) continue;
                        visited[nextX][nextY] = true;
                        cnt += 1;
                        posQ.add(new Pos(nextX, nextY));
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean inRange(int x, int y, boolean[][] visited) {
        return x >= 0 && x < visited.length && y >= 0 && y < visited[0].length;
    }

    public static void initialize(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }
}