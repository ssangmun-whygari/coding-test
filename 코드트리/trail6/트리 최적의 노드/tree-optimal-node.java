import java.util.*;
public class Main {
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int x = 0;
    public static int maxDist = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // x 구하기
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        Arrays.fill(visited, false);
        dfs(x, 0);

        // maxDist가 곧 지름
        int ans = (maxDist % 2 == 0) ? maxDist / 2 : (maxDist / 2) + 1;
        System.out.print(ans);
    }

    public static void dfs(int cur, int depth) {
        for (int next : graph[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (maxDist < depth + 1) {
                maxDist = depth + 1;
                x = next;
            }
            dfs(next, depth + 1);
        }
    }
}