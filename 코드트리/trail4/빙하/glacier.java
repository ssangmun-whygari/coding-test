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
    public static int N;
    public static int M;
    public static boolean[][] meltingWaterCells;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                grid[i][j] = sc.nextInt();

        meltingWaterCells = new boolean[N][M];
        meltingWaterCells[0][0] = true;
        bfs();

        int elapsed = 0;
        int lastMelted = 0;

        // System.out.println("meltingWaterCells : ");
        // for (int i = 0; i < N; i++) {
        //   for (int j = 0; j < M; j++) {
        //     if (meltingWaterCells[i][j] == true) {
        //       System.out.print(1 + " ");
        //     } else {
        //       System.out.print(0 + " ");
        //     }
        //   }
        //   System.out.println();
        // }

        while (true) {
          int cnt = expand();
          bfs(); // meltingWaterCells 갱신

          // System.out.println("meltingWaterCells, elapsed : " + (elapsed + 1));
          // for (int i = 0; i < N; i++) {
          //   for (int j = 0; j < M; j++) {
          //     if (meltingWaterCells[i][j] == true) {
          //       System.out.print(1 + " ");
          //     } else {
          //       System.out.print(0 + " ");
          //     }
          //   }
          //   System.out.println();
          // }

          if (cnt > 0) {
            elapsed++;
            lastMelted = cnt;
          } else {
            break;
          }
        }
        System.out.print(elapsed + " " + lastMelted);
    }

    public static void initialize(boolean[][] grid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = false;
            }
        }
    }

    public static void bfs() {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};

        Queue<Pos> posQ = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if (meltingWaterCells[i][j]) {
              posQ.add(new Pos(i, j));
            }
          }
        }

        while (!posQ.isEmpty()) {
            Pos cur = posQ.poll();
            for (int d = 0; d < 4; d++) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                if (!inRange(nextX, nextY)) continue;
                if (meltingWaterCells[nextX][nextY] == true) continue; // 재방문하지 않는다.
                if (grid[nextX][nextY] == 0) { // 물이면 큐에 넣는다.
                  meltingWaterCells[nextX][nextY] = true;
                  posQ.add(new Pos(nextX, nextY));
                }
            }
        }
    }

    public static int expand() {
      int[] dx = new int[] {0, 1, 0, -1};
      int[] dy = new int[] {1, 0, -1, 0};
      int cnt = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (meltingWaterCells[i][j]) {
            for (int d = 0; d < 4; d++) {
              int nextX = i + dx[d];
              int nextY = j + dy[d];
              if (!inRange(nextX ,nextY)) continue;
              if (grid[nextX][nextY] == 1) { // 얼음을 녹인다.
                grid[nextX][nextY] = 0;
                cnt++;
              }
            }
          }
        }
      }
      return cnt;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}