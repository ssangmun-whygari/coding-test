import java.util.*;

public class Main {
    public static int OFFSET = 1000;
    public static int MAX = 2001;

    public static void main(String[] args) {
        // 1. 첫번째 직사각형을 1로 덮는다.
        // 2. 두번째 직사강형을 2로 덮는다.
        // 3. 값이 1인 x, y 좌표의 최대 최소를 각각 구한다.

        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[MAX][MAX];
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0;

        for (int i = 1; i <= 2; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    grid[j + OFFSET][k + OFFSET] = i;
                }
            }
        }

        int minX = MAX; int minY = MAX; int maxX = -1; int maxY = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 1) continue;
                if (i < minX) minX = i;
                if (i > maxX) maxX = i;
                if (j < minY) minY = j;
                if (j > maxY) maxY = j;
            }
        }

        int area = 0;
        int width = 0; int height = 0;
        if (minX != MAX && minY != MAX && maxX != -1 && maxY != -1) {
            width = maxX - minX + 1;
            height = maxY - minY + 1;
            area = width * height;
        }
        System.out.println(area);
    }
}