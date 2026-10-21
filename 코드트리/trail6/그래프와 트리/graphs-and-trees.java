import java.util.*;
public class Main {

    public static TreeSet<Integer> v_unvisit = new TreeSet<>();
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[] parent;
    public static boolean hasCycle;
    public static int treeCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 1; i <= n; i++) {
            v_unvisit.add(i);
        }

        while (!v_unvisit.isEmpty()) {
            process();
        }

        System.out.print(treeCnt);
    }

    public static void process() {
        if (v_unvisit.isEmpty()) {
            throw new RuntimeException("예상외 입력");
        }

        int start = v_unvisit.first();
        Arrays.fill(visited, false);
        visited[start] = true;
        v_unvisit.remove(start);
        hasCycle = false;

        dfs(start, 0);

        if (!hasCycle) {
            treeCnt++;
        }
    }

    public static void dfs(int cur, int parent) {
        for (int next : graph[cur]) {
            if (visited[next]) {
                if (parent > 0 && next != parent) {
                    hasCycle = true;
                }
                continue;
            }

            visited[next] = true;
            v_unvisit.remove(next);

            dfs(next, cur);
        }
    }
}