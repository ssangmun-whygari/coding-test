import java.util.*;
public class Main {

    public static List<Integer>[] edges;
    public static int[] parent;
    public static int[] parent_after;
    public static boolean[] visited;
    public static int[] childNum;
    public static int central_node = 0;
    public static int last_visit_node;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = sc.nextInt();
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }
        visited = new boolean[n + 1];
        visited[root] = true;
        childNum = new int[n + 1];

        dfs(root);

        parent_after = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent_after[i] = parent[i];
        }
        dfs2(root);
        
        dp = new int[n + 1];
        if (central_node > 0) {
            dfs3(central_node);
        } else {
            System.out.print(0);
            System.exit(0);
        }
        

        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;
        for (int next : edges[central_node]) {
            if (parent_after[next] != central_node) continue;
            minVal = Math.min(dp[next], minVal);
            maxVal = Math.max(dp[next], maxVal);
        }

        System.out.print(maxVal - minVal);
    }

    public static int dfs3(int cur) {
        int cnt = 1;
        for (int next : edges[cur]) {
            if (parent_after[next] != cur) continue;
            cnt += dfs3(next);
        }
        dp[cur] = cnt;
        return cnt;
    }

    public static void dfs2(int cur) {
        last_visit_node = cur;
        if (central_node == 0 && childNum[cur] > 1) {
            central_node = cur;
            parent_after[central_node] = 0;
        }
        if (central_node > 0) return;

        for (int next : edges[cur]) {
            if (parent[next] != cur) continue;
            if (central_node == 0) {
                parent_after[cur] = next;
            }
            dfs2(next);
        }
    }

    public static void dfs(int cur) {
        int cnt = 0;
        for (int next : edges[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            parent[next] = cur;
            dfs(next);
            cnt++;
        }
        childNum[cur] = cnt;
    }
}