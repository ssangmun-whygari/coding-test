import java.util.*;

public class Main {
    public static int[] dx = new int[] {1, 0, -1, 0}; // 행
    public static int[] dy = new int[] {0, 1, 0, -1}; // 열
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] grid = new int[N][M];

        grid[0][0] = 1;
        int curX = 0, curY = 0;
        int dir = 0; // 초기값은 아래
        for (int i = 2; i <= N * M; i++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];
            if (!inRange(nx, ny) || grid[nx][ny] != 0) { // 방향 꺾어야 함
                dir = (dir + 1) % 4;
            }
            curX = curX + dx[dir];
            curY = curY + dy[dir];
            grid[curX][curY] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}