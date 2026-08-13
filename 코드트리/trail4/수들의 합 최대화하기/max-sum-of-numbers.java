import java.util.Scanner;
public class Main {
    public static int[][] grid;
    public static boolean[] visited;
    public static int n;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        visited = new boolean[n];
        recur(0, 0);

        System.out.print(ans);
    }

    public static void recur (int curRow, int sum) {
        if (curRow >= n) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (visited[col]) continue;
            visited[col] = true;
            recur(curRow + 1, sum + grid[curRow][col]);
            visited[col] = false;
        }
    }
}