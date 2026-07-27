import java.util.*;
public class Main {
    public static int OFFSET = 1000;
    public static int MAX_N = 2001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0;
        
        int[][] grid = new int[MAX_N][MAX_N];

        // 첫번째 사각형
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();

        for (int i = x1; i < x2; i++)
            for (int j = y1; j < y2; j++)
                grid[i + OFFSET][j + OFFSET] = 1;

        // 두번째 사각형
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();

        for (int i = x1; i < x2; i++)
            for (int j = y1; j < y2; j++)
                grid[i + OFFSET][j + OFFSET] = 1;

        // 세번째 사각형
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();

        for (int i = x1; i < x2; i++)
            for (int j = y1; j < y2; j++)
                grid[i + OFFSET][j + OFFSET] = 0;

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                area += grid[i][j];
            }
        }
        System.out.println(area);
    }
}