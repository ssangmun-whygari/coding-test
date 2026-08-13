import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;
    public static boolean[] visited;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        visited = new boolean[n];
        recur(Integer.MAX_VALUE, 0);

        System.out.println(ans);
    }

    public static void recur(int min, int curRow) {
        if (curRow == n) {
            ans = Math.max(min, ans);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (visited[col]) continue;
            visited[col] = true;
            recur(Math.min(min, grid[curRow][col]), curRow + 1);
            visited[col] = false;
        }
    }
}