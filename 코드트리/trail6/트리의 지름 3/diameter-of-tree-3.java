import java.util.*;

class Node {
    public int id;
    public int dist;

    Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}

public class Main {
    public static List<Node>[] graph;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<Node>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();
            graph[u].add(new Node(v, d));
            graph[v].add(new Node(u, d));
        }

        // x 찾기
        visited[1] = true;
        dfs(1);
        int x = 0;
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                x = i;
            }
        }

        // y찾기
        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);
        visited[x] = true;
        dfs(x);
        List<Integer> y = new ArrayList<>();

        maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                y.add(i);
            }
        }
        // System.out.println("x : " + x + ", y : " + y);
        y.add(x);
        int answer = findSecond(y);

        System.out.print(answer);
    }

    public static int findSecond(List<Integer> y) {
        int second = 0;
        for (int k : y) {
            Arrays.fill(visited, false);
            Arrays.fill(dist, 0);
            visited[k] = true;
            dfs(k);

            Arrays.sort(dist);
            second = Math.max(second, dist[dist.length - 2]);
        }
        return second;
    }

    public static void dfs(int cur) {
        for (Node next : graph[cur]) {
            if (visited[next.id]) continue;
            visited[next.id] = true;

            dist[next.id] = dist[cur] + next.dist;

            dfs(next.id);
        }
    }
}