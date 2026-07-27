import java.util.*;

public class Main {
    public static int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0;
        int[][] grid = new int[OFFSET * 2 + 1][OFFSET * 2 + 1];
        
        for (int i = 0; i < N; i++) {
            x1 = sc.nextInt() + OFFSET;
            y1 = sc.nextInt() + OFFSET;
            x2 = sc.nextInt() + OFFSET;
            y2 = sc.nextInt() + OFFSET;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    grid[j][k] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                answer += grid[i][j];
            }
        }
        System.out.println(answer);
    }
}