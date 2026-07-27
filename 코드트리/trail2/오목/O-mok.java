import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        // 가로, /, 세로, \
        int[] dx = new int[] {0, -1, 1, 1};
        int[] dy = new int[] {1, 1, 0, 1};
        int winner = 0, x = 0, y = 0;
        boolean found = false;

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    // 1, 2, 3, 4, 5번째 바둑돌에 대하여
                    for (int d = 0; d < 5; d++) { 
                        // i + d * dx[dir], j + d * dy[dir]
                        int nx = i + d * dx[dir];
                        int ny = j + d * dy[dir];
                        if (!inRange(nx, ny)) {
                            found = false;
                            break;
                        }
                        if (arr[nx][ny] == 0) {
                            found = false;
                            break;
                        }
                        if (d == 0) continue;
                        if (arr[nx][ny] != arr[nx - dx[dir]][ny - dy[dir]]) {
                            found = false;
                            break;
                        }
                        found = true;
                    }
                    if (found == true) {
                        winner = arr[i][j];
                        // System.out.println("i : " + i + ", j : " + j + ", dir : " + dir);
                        x = i + 2 * dx[dir];
                        y = j + 2 * dy[dir];
                        break;
                    }
                }
                if (found) break;
            }
            if (found) break;
        }

        System.out.println(winner);
        if (found) {
            System.out.println((x + 1) + " " + (y + 1));
        }

    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < 19 && y >= 0 && y < 19);
    }
}