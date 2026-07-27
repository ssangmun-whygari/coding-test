import java.util.Scanner;
public class Main {
    public static int[] dx = new int[] {0, 1, 0, -1}; // 행
    public static int[] dy = new int[] {1, 0, -1, 0}; // 열
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    if (inRange(nx, ny) && grid[nx][ny] == 1)
                        num += 1;
                }
                if (num >= 3)
                    ans++;
            }
        }

        System.out.println(ans);
    }

    public static boolean inRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}