import java.util.*;
public class Main {
    public static int[] dist; // 루트에서 각 노드로 도착할때의 길이
    public static boolean[] isLeaf;
    public static List<Integer>[] graph;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dist = new int[n + 1];
        isLeaf = new boolean[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 구축
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited[1] = true;
        traverse(0, 1);

        long totalDist = 0;
        for (int i = 1; i <= n; i++) {
            if (isLeaf[i] == true) {
                totalDist += dist[i];
            }
        }

        // System.out.println("totalDist : " + totalDist);
        System.out.println(totalDist % 2 == 0 ? 0 : 1);
    }

    public static void traverse(int level, int cur) {
        boolean isLeafNode = true;

        for (int next : graph[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            isLeafNode = false;
            dist[next] = level + 1;
            traverse(level + 1, next);
        }

        if (isLeafNode) {
            isLeaf[cur] = true;
        }
    }
}