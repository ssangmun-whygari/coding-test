import java.util.*;
public class Main {
    public static int MAX_DIST = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int z = sc.nextInt();
            graph[x][y] = z;
            graph[y][x] = z;
        }

        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;

        // b -> a
        int[] dist = new int[n];
        Arrays.fill(dist, MAX_DIST);
        dist[b] = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int minIdx = -1;
            int minDist = MAX_DIST;
            for (int j = 0; j < n; j++) {
                if (visited[j]) continue;
                if (minIdx == -1 || dist[j] < minDist) {
                    minIdx = j;
                    minDist = dist[j];
                }
            }

            visited[minIdx] = true;

            for (int j = 0; j < n; j++) {
                if (graph[minIdx][j] == 0) continue;
                int newDist = minDist + graph[minIdx][j];
                if (newDist < dist[j]) {
                    dist[j] = newDist;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(a);
        int cur = a;
        while (cur != b) {
            // graph[cur][x] : cur -> x
            // dist[x] : x -> b
            // dist[cur] : cur -> b
            for (int x = 0; x < n; x++) {
                if (graph[cur][x] == 0) continue;

                if (graph[cur][x] + dist[x] == dist[cur]) {
                    cur = x;
                    path.add(cur);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[a] + "\n");
        for (int v : path) {
            sb.append((v + 1) + " ");
        }
        System.out.println(sb.toString());
    }
}