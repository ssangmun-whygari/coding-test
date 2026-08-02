import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int cur_row = 0;
        while (true) {
            // (cur_row + 1, k) ~ (cur_row + 1, k + m - 1)
            boolean canProceed = true;
            if (cur_row >= n - 1) { // 블록이 끝 향에 도달
                canProceed = false;
                break;
            }

            for (int i = k; i <= k + m - 1; i++) {
                if (grid[cur_row + 1][i] == 1) {
                    canProceed = false;
                    break;
                }
            }

            if (canProceed) {
                cur_row += 1;
            } else {
                break;
            }
        }

        for (int i = k; i <= k + m - 1; i++) {
            grid[cur_row][i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}