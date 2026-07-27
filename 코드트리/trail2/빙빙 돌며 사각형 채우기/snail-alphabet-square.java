import java.util.Scanner;
public class Main {
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        char[][] grid = new char[N][M];
        int curX = 0, curY = 0;
        int dir = 0;
        grid[curX][curY] = 'A';

        for (int offset = 1; offset < N * M; offset++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            if (inRange(nx, ny) && grid[nx][ny] == '\u0000') {
                curX = nx;
                curY = ny;
            } else {
                dir = (dir + 1) % 4;
                curX = curX + dx[dir];
                curY = curY + dy[dir];
            }
            
            grid[curX][curY] = (char) ('A' + (offset % 26));
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