import java.util.*;

public class Main {
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        int[][] grid = new int[N][N];
        
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1; // 0-based
            int c = sc.nextInt() - 1;

            int adj = 0;
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dx[dir];
                int nc = c + dy[dir];
                if (inRange(nr, nc) && grid[nr][nc] != 0) {
                    adj++;
                }
            }

            if (adj == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

            grid[r][c] = 1;
        }
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}