import java.util.*;

public class Main {
    public static List<Integer>[] edges;
    public static int[] parent;
    public static int[] dp;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int q = sc.nextInt();

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }

        parent = new int[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];
        visited[r] = true;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            sb.append(dp[query] + "\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int u) {
        for (int v : edges[u]) {
            if (visited[v]) continue;
            visited[v] = true;
            parent[v] = u;
            dfs(v);
        }

        dp[u] = 1;
        for (int v : edges[u]) {
            // v가 자기 자식일때만 진행
            if (parent[v] == u)  {
                dp[u] += dp[v];
            }
        }
    }

}