import java.util.*;

public class Main {
    public static int MAX = 201;
    public static int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] grid = new int[MAX][MAX];
        int[] x1 = new int[N];
        int[] y1 = new int[N];
        int[] x2 = new int[N];
        int[] y2 = new int[N];

        for (int i = 0; i < N; i++) {
            x1[i] = sc.nextInt() + OFFSET;
            y1[i] = sc.nextInt() + OFFSET;
            x2[i] = sc.nextInt() + OFFSET;
            y2[i] = sc.nextInt() + OFFSET;
        }

        for (int i = 0; i < N; i++) {
            for (int x = x1[i]; x < x2[i]; x++) {
                for (int y = y1[i]; y < y2[i]; y++) {
                    if (i % 2 == 0) {
                        grid[x][y] = -1; // 빨간색
                    } else {
                        grid[x][y] = 1; // 파란색
                    }
                }
            }
        }

        int area = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (grid[i][j] == 1) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}