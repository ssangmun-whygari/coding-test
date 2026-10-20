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
    public static int[] dist;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1]; // 1 ~ n
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        visited[1] = true;
        traverse(1);

        int x = 0;
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
                x = i;
            }
        }
        
        Arrays.fill(dist, 0);
        Arrays.fill(visited, false);
        traverse(x);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }

        System.out.print(ans);
    }

    public static void traverse(int x) {
        for (Node next : graph[x]) {
            if (visited[next.id]) continue;
            visited[next.id] = true;
            dist[next.id] = dist[x] + next.dist;
            traverse(next.id);
        }
    }
}