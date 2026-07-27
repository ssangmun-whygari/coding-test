import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            int recent = grid[r][0];
            int repeat = 1;
            int maxRepeat = 1;
            for (int c = 1; c < N; c++) {
                if (grid[r][c] == recent) {
                    repeat++;
                    maxRepeat = Math.max(repeat, maxRepeat);
                } else {
                    recent = grid[r][c];
                    repeat = 1;
                }
            }
            if (maxRepeat >= M) answer++;
        }

        for (int c = 0; c < N; c++) {
            int recent = grid[0][c];
            int repeat = 1;
            int maxRepeat = 1;
            for (int r = 1; r < N; r++) {
                if (grid[r][c] == recent) {
                    repeat++;
                    maxRepeat = Math.max(repeat, maxRepeat);
                } else {
                    recent = grid[r][c];
                    repeat = 1;
                }
            }
            if (maxRepeat >= M) answer++;
        }

        System.out.println(answer);
    }
}