import java.util.Scanner;

public class Main {
    public static int[][] grid;
    public static int n;
    public static int m;
    public static int maxGold = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int maxK = n;
        // System.out.println("maxK : " + maxK);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxK; k++) {
                    dig(i, j, k);
                }
            }
        }

        System.out.println(maxGold);
    }

    public static void dig(int x, int y, int k) {
        int cost = 0;
        int gold = 0;

        for (int i = 0; i <= k; i++) {
            for (int j = y - i; j <= y + i; j++) {
                cost++;
                if (x - k + i < 0 || x - k + i >= n) continue;
                if (j < 0 || j >= n) continue;
                if (grid[x - k + i][j] == 1) gold++;
            }
        }

        // i : 1, 0 -> 1, 2
        for (int i = k - 1; i >= 0; i--) {
            // grid[x + k - i][?]
            for (int j = y - i; j <= y + i; j++) {
                cost++;
                if (x + k - i < 0 || x + k - i >= n) continue;
                if (j < 0 || j >= n) continue;
                if (grid[x + k - i][j] == 1) gold++;
            }
        }

        if (gold > maxGold) {
            if (cost > m * gold) {
                // 비용이 더 큼
            } else {
                maxGold = gold;
            }
        }
    }

}