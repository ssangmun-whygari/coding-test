import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1]; // 1 ~ n
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, parent, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int x, List<Integer>[] graph, int[] parent, boolean[] visited) {
        for (int child : graph[x]) {
            if (visited[child] == true) continue;
            visited[child] = true;

            parent[child] = x;

            dfs(child, graph, parent, visited);
        }
    }
}