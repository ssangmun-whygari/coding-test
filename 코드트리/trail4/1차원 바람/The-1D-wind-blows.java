import java.util.Scanner;

public class Main {
    public static int[][] grid;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int q = sc.nextInt();
        grid = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                grid[i][j] = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);

            int curRow = r;
            int dir = (d == 'L') ? 0 : 1;

            // 위쪽 방향으로 전파
            while (curRow-- > 0) { 
                // r - 1 ~ 0까지 검사됨
                if (dir == 1) {
                    shiftLeft(curRow);
                } else {
                    shiftRight(curRow);
                }
                // printGrid();
                if (curRow == 0) break; // 전파할 위 행이 없음
                boolean canGo = check(curRow, curRow - 1);
                if (canGo) {
                    dir = 1 - dir; // 바람의 방향을 바꿈
                } else {
                    break;
                }
            }
            
            // 아래쪽 방향으로 전파
            curRow = r - 1;
            dir = (d == 'L') ? 0 : 1;
            while (true) {
                if (curRow > r - 1) { // curRow = r - 1일때는 이미 바람이 불었음
                    if (dir == 1) {
                        shiftLeft(curRow);
                    } else {
                        shiftRight(curRow);
                    }
                }
                // printGrid();
                if (curRow >= N - 1) break; // 전파할 아래 행이 없음
                boolean canGo = check(curRow, curRow + 1);
                if (canGo) {
                    dir = 1 - dir; // 바람의 방향을 바꿈
                    curRow++;
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void printGrid() {
        StringBuilder sb = new StringBuilder();
        sb.append("/////grid : \n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.append("/////");
        System.out.println(sb);
    }

    public static boolean check(int row1, int row2) {
        boolean result = false;
        for (int i = 0; i < M; i++) {
            if (grid[row1][i] == grid[row2][i]) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void shiftRight(int row) {
        int temp = grid[row][M - 1];
        for (int i = M - 1; i >= 1; i--) {
            grid[row][i] = grid[row][i - 1];
        }
        grid[row][0] = temp;
    }

    public static void shiftLeft(int row) {
        int temp = grid[row][0];
        for (int i = 0; i <= M - 2; i++) {
            grid[row][i] = grid[row][i + 1];
        }
        grid[row][M - 1] = temp;
    }
}