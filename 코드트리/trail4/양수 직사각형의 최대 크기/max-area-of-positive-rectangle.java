import java.util.Scanner;
public class Main {
    public static int answer = -1;
    public static int[][] grid;
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int width = 0; width < N; width++) {
            for (int height = 0; height < M; height++) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < M; c++) {
                        simulate(r, c, width, height);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }

    public static void simulate(int r, int c, int width, int height) {
        boolean allPositive = true;
        for (int dx = 0; dx <= width; dx++) {
            for (int dy = 0; dy <= height; dy++) {
                if (r + dx >= N || c + dy >= M) {
                    allPositive = false;
                    break;
                }
                if (grid[r + dx][c + dy] <= 0) {
                    allPositive = false;
                    break;
                }
            }
            if (!allPositive) break;
        }

        if (allPositive) {
            answer = Math.max((width + 1) * (height + 1), answer);
        }
    }
}