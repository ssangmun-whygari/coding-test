import java.util.*;
public class Main {
    public static int n;
    public static int MAX_DIST = (int) 2e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt() - 1;
        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            graph[u][v] = w;
        }

        int[] x_p = diijkstra(x, false, graph);
        int[] p_x = diijkstra(x, true, graph);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(p_x[i] + x_p[i], ans);
        }
        System.out.print(ans);
    }

    public static int[] diijkstra(int start, boolean reverse, int[][] graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, MAX_DIST);
        dist[start] = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int minIdx = -1;
            int minDist = MAX_DIST;
            for (int j = 0; j < n; j++) {
                if (visited[j]) continue;

                if (minIdx == -1 || minDist > dist[j]) {
                    minIdx = j;
                    minDist = dist[j];
                }
            }

            visited[minIdx] = true;

            for (int j = 0; j < n; j++) {
                int edgeLength = (reverse) ? graph[j][minIdx] : graph[minIdx][j];
                if (edgeLength == 0) continue;
                int newDist = minDist + edgeLength;
                if (newDist < dist[j]) {
                    dist[j] = newDist;
                }
            }
        }

        return dist;
    }
}