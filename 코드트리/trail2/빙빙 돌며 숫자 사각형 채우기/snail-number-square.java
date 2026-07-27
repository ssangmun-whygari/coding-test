import java.util.*;

public class Main {
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int[][] grid = new int[N][M];

        int x = 0, y = 0;
        grid[x][y] = 1;
        int dirNum = 0; // 오른쪽

        for (int i = 2; i <= N*M; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if (!inRange(nx, ny) || grid[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4;
            }

            x = x + dx[dirNum];
            y = y + dy[dirNum];

            grid[x][y] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}