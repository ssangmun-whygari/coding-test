import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            dist[u][v] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        for (int x = 1; x <= n; x++) {
            int cnt = 0;
            for (int y = 1; y <= n; y++) {
                if (dist[x][y] != 1 && dist[y][x] != 1) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}