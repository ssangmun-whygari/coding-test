import java.util.*;
public class Main {
    public static int n;
    public static int MAX_DIST = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
            graph[v][u] = w;
        }

        int[] dist_1_to_x = diijkstra(1, graph);
        int[] dist_x_to_n = diijkstra(n, graph);

        // 사전순으로 앞선 경로를 복원
        List<Integer> path = new ArrayList<>();
        int cur = 1;
        path.add(cur);
        while (cur != n) {
            for (int x = 1; x <= n; x++) {
                if (graph[cur][x] == 0) continue;
                if (graph[cur][x] + dist_x_to_n[x] == dist_x_to_n[cur]) {
                    path.add(x);
                    cur = x;
                    break;
                }
            }
        }
        // System.out.println("path : " + path);
        
        for (int i = 0; i < path.size() - 1; i++) {
            graph[path.get(i)][path.get(i + 1)] = 0;
            graph[path.get(i + 1)][path.get(i)] = 0;
        }
        int[] altDist = diijkstra(1, graph);
        System.out.print(altDist[n]);
    }

    public static int[] diijkstra(int start, int[][] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[start] = 0;

        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int minIdx = -1;
            int minDist = MAX_DIST;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) continue;

                if (minIdx == -1 || dist[j] < minDist) {
                    minIdx = j;
                    minDist = dist[j];
                }
            }

            visited[minIdx] = true;

            for (int j = 1; j <= n; j++) {
                int nextDist = graph[j][minIdx];
                if (nextDist == 0) continue;
                int newDist = minDist + nextDist;
                if (newDist < dist[j]) {
                    dist[j] = newDist;
                }
            }
        }

        return dist;
    }
}