import java.util.*;

public class Main {
    public static int[][] counts;
    public static int[][] balls; // 0, 1, 2, 3
    public static int[][] nextBalls;
    public static int[] dx = new int[] {0, 0, -1, 1}; // L, R, U, D
    public static int[] dy = new int[] {-1, 1, 0, 0};
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        while (T-- > 0) {
            N = sc.nextInt();
            int M = sc.nextInt();
            
            counts = new int[N][N];
            balls = new int[N][N];
            nextBalls = new int[N][N];

            for (int i = 0; i < N; i++)
                Arrays.fill(balls[i], -1);
            for (int i = 0; i < N; i++)
                Arrays.fill(nextBalls[i], -1);

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int dir = mapDir(sc.next().charAt(0));
                balls[x][y] = dir;
            }
            
            // System.out.println("초기 상태 : ");
            // printGrid(balls);

            int time = N * 2;
            while(time-- > 0) {
                simulate();
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans += counts[i][j];
                }
            }
            System.out.println(ans);
        }
    }

    public static void simulate() {
        // nextBalls, counts 초기화 초기화
        for (int i = 0; i < N; i++){
            Arrays.fill(nextBalls[i], -1);
            Arrays.fill(counts[i], 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int dir = balls[i][j];
                if (dir == -1) continue;
                int nextX = i + dx[dir];
                int nextY = j + dy[dir];
                if (inRange(nextX, nextY)) {
                    counts[nextX][nextY] += 1;
                    nextBalls[nextX][nextY] = dir; // 방향 저장
                } else {
                    counts[i][j] += 1;
                    nextBalls[i][j] = (dir ^ 1); // 방향 전환
                }
            }
        }

        // 충돌 처리
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (counts[i][j] > 1) counts[i][j] = 0;
        
        // balls 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (counts[i][j] < 1 || counts[i][j] > 1) {
                    nextBalls[i][j] = -1;
                }
            }  
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                balls[i][j] = nextBalls[i][j];
            }
        }

        // System.out.println("이동 후 : ");
        // printGrid(balls);
    }

    public static void printGrid(int[][] grid) {
      char[] mapper = new char[] {'L', 'R', 'U', 'D'};
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] >= 0) {
            sb.append(mapper[grid[i][j]]);
          } else {
            sb.append('X');
          }
          sb.append(' ');
        }
        sb.append('\n');
      }
      System.out.print(sb.toString());
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int mapDir(char dir) {
        if (dir == 'L') {
            return 0;
        } else if (dir == 'R') {
            return 1;
        } else if (dir == 'U') {
            return 2;
        } else if (dir == 'D') {
            return 3;
        }
        return -1;
    }
}