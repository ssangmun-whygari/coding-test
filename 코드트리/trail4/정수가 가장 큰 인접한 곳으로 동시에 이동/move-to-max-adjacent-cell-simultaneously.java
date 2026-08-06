import java.util.*;

public class Main {
    public static int[][] counts;
    public static int[][] nextCounts;
    public static int[][] grid;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        counts = new int[N][N];
        for (int i = 0; i < M; i++) {
            counts[sc.nextInt() - 1][sc.nextInt() - 1] = 1; // 구슬의 초기 위치 설정
        }
        nextCounts = new int[N][N];

        for (int i = 0; i < T; i++) {
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

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void simulate() {
        int[] dx = new int[] {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = new int[] {0, 0, -1, 1};
        // nextCounts 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextCounts[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (counts[i][j] == 0) continue;
                int nextI = -1, nextJ = -1;
                int maxVal = -1;
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (!inRange(ni, nj)) continue;
                    if (grid[ni][nj] > maxVal) {
                        maxVal = grid[ni][nj];
                        nextI = ni; nextJ = nj;
                    }
                }
                nextCounts[nextI][nextJ] += 1;
            }
        }

        // 충돌시켜 없앰
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nextCounts[i][j] > 1) {
                    nextCounts[i][j] = 0;
                }
            }
        }

        // counts 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                counts[i][j] = nextCounts[i][j];
            }
        }
    }
}