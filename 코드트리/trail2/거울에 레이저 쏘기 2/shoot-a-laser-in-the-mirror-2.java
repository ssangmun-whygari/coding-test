import java.util.*;

public class Main {
    public static int[] dx = new int[] {1, 0, -1, 0}; // 행 (아래, 왼, 위, 오른)
    public static int[] dy = new int[] {0, -1, 0, 1}; // 열 (아래, 왼, 위, 오른)
    public static int[] forwardEsc = new int[] {1, -1, 1, -1}; // 아래, 왼, 위, 오른
    public static int[] reverseEsc = new int[] {-1, 1, -1, 1}; // 아래, 왼, 위, 오른
    public static int N;

    public static void main(String[] args) {
        // 아래, / : 오90, 아래, \ : 왼90
        // 오른, / : 왼90, 오른, \ : 오90
        // 위, / : 오90, 위, \ : 왼90
        // 왼, / : 왼90, 왼, \ : 오90

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[][] grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            grid[i] = line.toCharArray();
        }

        int start = sc.nextInt() - 1; // 0 ~ 11
        int rotateNum = start / N;
        // System.out.println("rotateNum : " + rotateNum);
        while (rotateNum-- > 0) {
            grid = rotateGrid90(grid);
        }
        // printGrid(grid);
        int curX = 0, curY = start % N;
        // System.out.println("curX : " + curX + ", curY : " + curY);
        int dir = 0; // 초기 방향은 아래로 고정됨
        int ans = 0;
        
        while (++ans > 0) {
            if (grid[curX][curY] == '/') {
                // xxxEsc = 1이면 오른쪽 90도 회전, -1이면 왼쪽 90도 회전을 나타냄
                dir = (dir + 4 + forwardEsc[dir]) % 4;
            } else {
                dir = (dir + 4 + reverseEsc[dir]) % 4;
            }
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];
            // System.out.println("nx : " + nx + ", ny : " + ny);
            if (inRange(nx, ny)) {
                curX = nx; curY = ny;
            } else {
                break;
            }
        }

        System.out.println(ans);
    }

    // 원본 배열을 반시계 방향으로 90도 회전시킨다
    public static char[][] rotateGrid90(char[][] orig) {
        char[][] copy = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[N-1-j][i] = (orig[i][j] == '/' ? '\\' : '/');
            }
        }
        return copy;
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static void printGrid(char[][] grid) {
        for (char[] line : grid) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}