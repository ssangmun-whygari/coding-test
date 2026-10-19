import java.util.*;

class Node {
    public int dist;
    public int id;

    Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}

public class Main {
    public static List<Node>[] graph;
    public static boolean[] visited;
    public static int pathDist = 0;
    public static boolean pathFound = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int d = sc.nextInt();
            graph[u].add(new Node(v, d));
            graph[v].add(new Node(u, d));
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            init(visited);
            visited[u] = true;
            pathFound = false;
            pathDist = 0;
            traverse(0, u, v);

            System.out.println(pathDist);
        }
    }

    public static void traverse(int dist, int cur, int dest) {
        if (pathFound) return;

        if (cur == dest) {
            pathFound = true;
            pathDist = dist;
            return;
        }

        for (Node next : graph[cur]) {
            if (visited[next.id]) continue;
            visited[next.id] = true;
            traverse(dist + next.dist, next.id, dest);
        }
    }

    public static void init(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

}