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
    public static List<Node>[] graph;
    public static int n;
    public static int MAX_DIST = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<Node>();
        
        while (m-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int dist = sc.nextInt();
            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }

        int[] aDist = dijkstra(a);
        int[] bDist = dijkstra(b);
        int[] cDist = dijkstra(c);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // aDist[i], bDist[i], cDist[i]
            if (aDist[i] == MAX_DIST || bDist[i] == MAX_DIST || cDist[i] == MAX_DIST) {
                continue;
            }

            int minDist = Math.min(Math.min(aDist[i], bDist[i]), cDist[i]);
            ans = Math.max(minDist, ans);
        }

        System.out.print(ans);
    }

    public static int[] dijkstra(int x) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[x] = 0; // x -> x의 최단거리는 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        while (!pq.isEmpty()) {
            int minIdx = pq.peek().idx;
            int minDist = pq.peek().dist;
            pq.poll();

            if (minDist > dist[minIdx]) {
                continue;
            }

            for (Node next : graph[minIdx]) {
                int newDist = next.dist + minDist;
                if (newDist < dist[next.idx]) {
                    dist[next.idx] = newDist;
                    pq.add(new Node(next.idx, newDist));
                }
            }
        }

        return dist;
    }
}