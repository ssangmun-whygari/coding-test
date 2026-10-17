import java.util.*;

public class Main {
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = sc.nextInt();
        }
        int deleted = sc.nextInt();

        // 루트노드 찾기
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) root = i;
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int x = 0; x < n; x++) {
            int p = parent[x];
            if (p == -1) continue;
            graph[p].add(x);
        }

        boolean[] visited = new boolean[n];
        visited[root] = true;

        traverse(root, graph, deleted, visited);
        System.out.print(ans);
    }

    public static void traverse(int x, List<Integer>[] graph, int deleted, boolean[] visited) {
        if (x == deleted) return;

        if (graph[x].isEmpty() || (graph[x].size() == 1 && graph[x].get(0) == deleted)) {
            ans++;
        }

        for (int child : graph[x]) {
            if (visited[child] == true) continue;
            visited[child] = true;
            traverse(child, graph, deleted, visited);
        }
    }
}