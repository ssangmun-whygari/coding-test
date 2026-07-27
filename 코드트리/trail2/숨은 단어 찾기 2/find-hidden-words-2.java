import java.util.*;

public class Main {
    public static int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1}; // 북쪽부터 45도 회전
    public static int[] dy = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // (i, j), (i + dx[dir], j + dx[dir]), (i + 2*dx[dir], j + 2*dx[dir])
                for (int dir = 0; dir < 8; dir++) {
                    if (!inRange(i + dx[dir], j + dy[dir])) continue;
                    if (!inRange(i + 2*dx[dir], j + 2*dy[dir])) continue;
                    // System.out.println("i : " + i + ", j : " + j + ", dir : " + dir);
                    if (grid[i][j] == 'L' && 
                        grid[i + dx[dir]][j + dy[dir]] == 'E' && 
                        grid[i + 2*dx[dir]][j + 2*dy[dir]] == 'E') {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}