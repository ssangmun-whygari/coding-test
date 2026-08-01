import java.util.*;

public class Main {
    public static int[][] grid;
    public static int answer = 0;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        simulate();
        // bomb(2, 1);

        System.out.println(answer);
    }

    public static void simulate() {
        // 각 위치마다 폭탄 터트리기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bomb(i, j);
            }
        }
    }

    public static void bomb(int r, int c) {
        int[][] tempGrid = new int[N][N];
        int range = grid[r][c];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (inBombRange(i, j, r, c, range)) {
                    tempGrid[i][j] = 0;
                } else {
                    tempGrid[i][j] = grid[i][j];
                }
            }
        }
        // System.out.println("tempGrid : ");
        // printGrid(tempGrid);

        // 중력 작용
        int[][] temp2Grid = new int[N][N];
        for (int col = 0; col < N; col++) {
            int tempRow = N - 1;
            for (int row = N - 1; row >= 0; row--) {
                if (tempGrid[row][col] > 0) {
                    temp2Grid[tempRow--][col] = tempGrid[row][col];
                }
            }
        }

        // System.out.println("temp2Grid : ");
        // printGrid(temp2Grid);

        // 인접한 숫자 쌍의 개수를 샘
        int cnt = 0;
        // 가로로 셈
        for (int col = 0; col < N - 1; col++) {
            for (int row = 0; row < N; row++) {
                if (temp2Grid[col][row] > 0 && temp2Grid[col][row] == temp2Grid[col + 1][row])
                    cnt++;
            }
        }
        // 세로로 셈
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N - 1; row++) {
                if (temp2Grid[col][row] > 0 && temp2Grid[col][row] == temp2Grid[col][row + 1])
                    cnt++;
            }
        }
        // 정답 갱신
        answer = Math.max(answer, cnt);
    }

    public static boolean inBombRange(int r, int c, int r0, int c0, int range) {
        return (Math.abs(r - r0) + Math.abs(c - c0) < range) && (r == r0 || c == c0);
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}