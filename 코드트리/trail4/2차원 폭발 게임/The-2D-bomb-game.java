import java.util.*;
public class Main {
    public static int[][] grid;
    public static int[][] nextGrid;
    public static int N;
    public static int M;
    public static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        grid = new int[N][N];
        nextGrid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            // System.out.println(i + 1 + "번째 시도");
            simulate(i + 1);
        }


        int ans = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] > 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void explode() {
        for (int c = 0; c < N; c++) {
            // grid[0][c] ~ grid[N - 1][c]
            boolean exploded = false;
            do {
                exploded = false;
                int lastVal = -1;
                int cnt = 0;
                int endRow = 0; // nextGrid에서
                for (int r = 0; r < N; r++) {
                    if (grid[r][c] == 0) continue;
                    if (lastVal != grid[r][c]) {
                        if (cnt >= M) {
                            while (cnt-- > 0) {
                                nextGrid[endRow++][c] = 0;
                            }
                            exploded = true;
                        } else {
                            while (cnt-- > 0) {
                                nextGrid[endRow++][c] = lastVal;
                            }
                        }
                        lastVal = grid[r][c];
                        cnt = 1;
                    } else {
                        cnt += 1;
                    }
                }
                if (lastVal > 0 && cnt > 0) {
                    if (cnt >= M) {
                        while (cnt-- > 0) {
                            nextGrid[endRow++][c] = 0;
                        }
                        exploded = true;
                    } else {
                        while (cnt-- > 0) {
                            nextGrid[endRow++][c] = lastVal;
                        }
                    }
                }
                // grid를 열단위로 갱신
                for (int r = 0; r < N; r++) {
                  grid[r][c] = nextGrid[r][c];
                }
                for (int r = 0; r < N; r++) {
                  nextGrid[r][c] = 0;
                }
            } while (exploded == true);
        }
    }

    public static void gravity() {
      for (int c = 0; c < N; c++) {
          int endRow = N - 1;
          for (int r = N - 1; r >= 0; r--) {
              if (grid[r][c] > 0) {
                  nextGrid[endRow--][c] = grid[r][c];
              }
          }
          for (int r = endRow; r >= 0; r--) {
              nextGrid[r][c] = 0;
          }
      }
      for (int r = 0; r < N; r++) {
          for (int c = 0; c < N; c++) {
              grid[r][c] = nextGrid[r][c];
          }
      }
    }

    public static void rotate() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                nextGrid[c][N - 1 - r] = grid[r][c];
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = nextGrid[r][c];
            }
        }
    }

    public static void initializeGrid(int[][] grid) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          grid[i][j] = 0;
        }
      }
    }

    public static void simulate(int tryNum) {
        initializeGrid(nextGrid);

        // printGrid("grid", grid);
        explode();
        // printGrid("충돌 후 grid", grid);

        gravity();
        // printGrid("층동 + 중력 적용 후 grid", grid);

        rotate();
        // printGrid("회전 후 grid", grid);

        gravity();
        // printGrid("회전 + 중력적용 grid", grid);

        if (tryNum == K) {
          initializeGrid(nextGrid);
          explode();
        }
    }

    public static void printGrid(String title, int[][] grid) {
      System.out.println(title + " : ");
      for (int i = 0; i < grid.length; i++) {
        System.out.println(Arrays.toString(grid[i]));
      }
      System.out.println(title + " end");
    }
}