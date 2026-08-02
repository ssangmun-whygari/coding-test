import java.util.Scanner;
public class Main {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        char[][] maze = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j);
            }
        }



        int[] dx = new int[] {0, -1, 0, 1};
        int[] dy = new int[] {1, 0, -1, 0};
        int dir = 0;
        boolean[][][] visited = new boolean[n][n][4];
        visited[x][y][dir] = true;
        boolean escape = false;
        int t = 0;
        while (true) {
            int nx = 0, ny = 0;
            for (int d = 0; d < 4; d++) {
                nx = x + dx[dir];
                ny = y + dy[dir];
                if (inRange(nx, ny) && maze[nx][ny] == '#') { // 가고자 하는 방향이 막혀있음
                    dir = (dir + 1) % 4;
                } else if (inRange(nx, ny) && maze[nx][ny] == '.') {
                    int right_dir = (dir + 3) % 4;
                    int nnx = nx + dx[right_dir];
                    int nny = ny + dy[right_dir];

                    if ((inRange(nnx, nny) && maze[nnx][nny] == '#') || !inRange(nnx, nny)) {
                        // 그냥 한 칸 전진 가능
                        t++;
                        break;
                    } else if (inRange(nnx, nny) && maze[nnx][nny] == '.') { // (nx, ny)의 오른쪽 벽이 없음
                        nx = nnx; ny = nny;
                        dir = right_dir;
                        t += 2;
                        break;
                    }
                } else { // 격자 탈출
                    escape = true;
                    t++;
                    break;
                }
            }

            if (escape) {
              break;
            }

            if (visited[nx][ny][dir] == true) {
              break;
            } else {
              visited[nx][ny][dir] = true;
              x = nx; y = ny;
            }
        }

        if (escape) {
            System.out.print(t);
        } else {
            System.out.print(-1);
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}