import java.util.*;

class Node implements Comparable<Node> {
    public int idx;
    public int dist;

    Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}

public class Main {
    public static int MAX_DIST = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt();

        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        
        int[] dist = new int[n];
        Arrays.fill(dist, MAX_DIST);
        dist[a] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int minIdx = cur.idx;
            int minDist = cur.dist;

            if (minDist > dist[minIdx]) {
                continue;
            }

            for (Node next : graph[minIdx]) {
                int targetIdx = next.idx;
                int newDist = minDist + next.dist;
                if (newDist < dist[targetIdx]) {
                    dist[targetIdx] = newDist;
                    pq.add(new Node(targetIdx, newDist));
                }
            }
        }
        
        System.out.print(dist[b]);
    }
}