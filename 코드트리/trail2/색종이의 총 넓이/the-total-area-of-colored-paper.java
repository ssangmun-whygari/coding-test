import java.util.*;

public class Main {
    public static int SIZE = 8;
    public static int MAX = 201;
    public static int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[MAX][MAX];
        int x = 0; int y = 0;

        for (int i = 0; i < N; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            for (int j = x; j < x + SIZE; j++) {
                for (int k = y; k < y + SIZE; k++) {
                    grid[j + OFFSET][k + OFFSET] = 1;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                area += grid[i][j];
            }
        }
        System.out.println(area);
    }
}