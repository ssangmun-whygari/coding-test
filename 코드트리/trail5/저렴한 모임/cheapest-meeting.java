import java.util.Scanner;
public class Main {
    public static int MAX_DIST = (int) 1e8; // 1억

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int e = sc.nextInt();

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = MAX_DIST;
            }
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int x = 1; x <= n; x++) {
            // x : 합류하는 점
            // dist[v1][x], dist[v2][x], dist[x][e]
            if (dist[v1][x] < MAX_DIST && dist[v2][x] < MAX_DIST && dist[x][e] < MAX_DIST) {
                minCost = Math.min(minCost, dist[v1][x] + dist[v2][x] + dist[x][e]);
            }
        }

        System.out.print(minCost == Integer.MAX_VALUE ? -1 : minCost);
    }
}