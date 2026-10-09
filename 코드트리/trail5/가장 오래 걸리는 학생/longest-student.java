import java.util.*;

class Node implements Comparable<Node> {
    public int idx, dist;

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
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[v].add(new Node(u, w));
            graph[u].add(new Node(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[n] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        while (!pq.isEmpty()) {
            int minIdx = pq.peek().idx;
            int minDist = pq.peek().dist;
            pq.poll();
            if (minDist > dist[minIdx]) continue;

            for (Node next : graph[minIdx]) {
                int targetIdx = next.idx;
                int newDist = minDist + next.dist;
                if (newDist < dist[targetIdx]) {
                    dist[targetIdx] = newDist;
                    pq.add(new Node(targetIdx, newDist));
                }
            }
        }
        // System.out.println("dist : " + Arrays.toString(dist));

        int ans = 0;
        for (int i = 1; i <= n - 1; i++) {
            ans = Math.max(ans, dist[i]);
        }
        System.out.print(ans);
    }
}