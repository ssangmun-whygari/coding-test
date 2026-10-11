import java.util.*;

public class Main {
    public static int MAX_DIST = (int) 1e9; // 10억
    public static int N;
    public static int P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        P = sc.nextInt();
        int Q = sc.nextInt();

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = MAX_DIST;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            dist[u][v] = Math.min(w, dist[u][v]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int cnt = 0;
        long sum = 0;
        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int minDist = executeQuery(x, y, dist);
            if (minDist != Integer.MAX_VALUE) {
                sum += minDist;
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sum);
    }

    public static int executeQuery(int x, int y, int[][] dist) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i <= P; i++) {
            // dist[x][i] + dist[i][y]
            if (dist[x][i] < MAX_DIST && dist[i][y] < MAX_DIST) {
                minDist = Math.min(dist[x][i] + dist[i][y], minDist);
            }
        }
        return minDist;
    }
}