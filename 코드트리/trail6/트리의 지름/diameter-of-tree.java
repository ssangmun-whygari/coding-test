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
    public static int diameter = 0;
    public static int v = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();    
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        traverse(1, 0, graph, visited);
        // System.out.println("v : " + v + ", diameter : " + diameter);
        
        Arrays.fill(visited, false);
        visited[v] = true;
        traverse(v, 0, graph, visited);

        // System.out.println("v : " + v + ", diameter : " + diameter);
        System.out.print(diameter);
    }

    public static void traverse(int x, int dist, List<Node>[] graph, boolean[] visited) {
        if (dist > diameter) {
            v = x;
            diameter = dist;
        }

        for (Node next : graph[x]) {
            if (visited[next.id] == true) continue;
            visited[next.id] = true;

            traverse(next.id, next.dist + dist, graph, visited);
        }
    }
}