import java.util.*;

public class Main {
    public static int MAX_DIST = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, MAX_DIST);
        dist[0] = 0;

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            graph[u][v] = w;
        }
        
        for (int i = 0; i < n; i++) {
            // 최소 거리 점 찾기
            int minIdx = -1;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }

                if (minIdx == -1 || dist[j] < dist[minIdx]) {
                    minIdx = j;
                }
            }

            visited[minIdx] = true; // 0 -> minIdx 번 점의 최소거리 확정

            for (int j = 0; j < n; j++) {
                if (graph[minIdx][j] != 0) {
                    dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(dist[i] == MAX_DIST ? -1 : dist[i]);
        }
    }
}