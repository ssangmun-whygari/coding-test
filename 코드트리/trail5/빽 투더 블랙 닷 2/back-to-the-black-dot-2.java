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
    public static int MAX_DIST = (int) 2e8;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int red1 = sc.nextInt();
        int red2 = sc.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int[] red1_start_dist = diijkstra(red1);
        int[] red2_start_dist = diijkstra(red2);

        int ans = Integer.MAX_VALUE;
        for (int x = 1; x <= n; x++) {
            int sum = 0;
            if (x == red1 || x == red2) continue;
            sum += red1_start_dist[x]; // x -> red1의 거리
            sum += red1_start_dist[red2]; // red1 -> red2의 거리
            sum += red2_start_dist[x]; // red2 -> x의 거리
            if (red1_start_dist[x] < MAX_DIST && red1_start_dist[red2] < MAX_DIST && red2_start_dist[x] < MAX_DIST) {
                ans = Math.min(ans, sum);
            }
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static int[] diijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
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

        return dist;
    }
}