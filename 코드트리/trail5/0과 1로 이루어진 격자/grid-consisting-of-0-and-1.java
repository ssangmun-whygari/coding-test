import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    invert(grid, i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    public static void invert(int[][] grid, int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                grid[i][j] = 1 - grid[i][j];
            }
        }
    }
}