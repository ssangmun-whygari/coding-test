import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();
        String cmds = sc.next();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] dx = new int[] {-1, 0, 1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        int dir = 0;

        int curX = N / 2, curY = N / 2;
        int score = grid[curX][curY];

        for (char cmd : cmds.toCharArray()) {
            if (cmd == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else if (cmd == 'R') {
                dir = (dir + 1) % 4;
            } else {
                // 이동
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                // 점수 획득
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    curX = nx; curY = ny;
                    score += grid[curX][curY];
                }
            }
        }

        System.out.println(score);
    }
}