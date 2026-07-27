import java.util.*;

public class Main {
    public static int[][] grid;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int Q = sc.nextInt();

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // printGrid();
        for (int q = 0; q < Q; q++) {
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;

            process1(r1, c1, r2, c2);
            process2(r1, c1, r2, c2);
        }

        printGrid();
    }

    public static void process1(int r1, int c1, int r2, int c2) {
        int[] lengths = new int[] {c2 - c1, r2 - r1, c2 - c1, r2 - r1};
        int[] dy = new int[] {1, 0, -1, 0};
        int[] dx = new int[] {0, 1, 0, -1};
        Deque<Integer> deque = new ArrayDeque<>();

        // 경계를 따라 덱에 넣는다.
        int r = r1; 
        int c = c1;
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < lengths[d]; i++) {
                deque.add(grid[r][c]);
                r += dx[d]; c += dy[d];
            }
        }

        // 한 칸 회전
        deque.addFirst(deque.pollLast());

        // 덱에서 꺼내서 원본 그리드에 다시 넣는다.
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < lengths[d]; i++) {
                grid[r][c] = deque.poll();
                r += dx[d]; c += dy[d];
            }
        }
        
        // System.out.println("process1 후 : ");
        // printGrid();
        // System.out.println("process1 후 : END");
    }

    public static void process2(int r1, int c1, int r2, int c2) {
        int[][] newGrid = new int[N][M];
        int[] dy = new int[] {0, 1, 0, -1};
        int[] dx = new int[] {-1, 0, 1, 0};

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                int avg = grid[r][c];
                int blockNum = 1;
                for (int d = 0; d < 4; d++) {
                    // c + dy[d], r + dx[d]
                    if (inRange(r + dx[d], c + dy[d])) {
                        avg += grid[r + dx[d]][c + dy[d]];
                        blockNum++;
                    } else {
                        continue;
                    }
                }
                avg /= blockNum;
                newGrid[r][c] = avg;
            }
        }

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                grid[r][c] = newGrid[r][c];
            }
        }
        // System.out.println("process2 후 : ");
        // printGrid();
        // System.out.println("process2 후 : END");
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static void printGrid() {
      StringBuilder sb = new StringBuilder();
      for (int r = 0; r < N; r++) {
          for (int c = 0; c < M; c++) {
              sb.append(grid[r][c] + " ");
          }
          sb.append("\n");
      }
      System.out.println(sb);
    }
}