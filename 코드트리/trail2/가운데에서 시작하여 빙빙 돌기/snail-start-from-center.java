import java.util.*;

public class Main {
    public static int[] dx = new int[] {0, -1, 0, 1};
    public static int[] dy = new int[] {1, 0, -1, 0};
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] grid = new int[N][N];

        int curX = N / 2, curY = N / 2;
        grid[curX][curY] = 1;
        int dir = 0; // 초기값은 오른쪽

        // i = 0, 1, 2, 3, 4, 5, 6, 일때
        //     1, 1, 2, 2, 3, 3... 칸씩 이동
        int i = 0;
        while (true) {
            int j = (i / 2) + 1;
            boolean flag = false;
            while (j-- > 0) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if (inRange(nx, ny)) {
                    grid[nx][ny] = grid[curX][curY] + 1;
                    curX = nx; curY = ny;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            dir = (dir + 1) % 4; // 방향전환
            i++;
        }

        for (i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}