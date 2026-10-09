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

class Pair {
    public int[] dist;
    public int[] path;

    Pair(int[] dist, int[] path) {
        this.dist = dist;
        this.path = path;
    }
}

public class Main {
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static int n;
    public static int MAX_DIST = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        List<Node>[] graph = new ArrayList[n + 1];
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

        Pair pair = diijkstra(graph, 0, 0);
        int[] dist = pair.dist;
        int[] parent = pair.path;

        int minDist = dist[n];
        int[] path = makePath(parent);
        // System.out.println("path : " + Arrays.toString(path));
        int ans = 0;
        for (int i = 0; i < path.length - 1; i++) {
            int from = path[i];
            int to = path[i + 1];

            Pair altPair = diijkstra(graph, from, to);
            int[] altDist = altPair.dist;
            if (minDist != altDist[n]) {
                // System.out.println("from : " + from + ", to : " + to);
                ans++;
            }
        }

        System.out.print(ans);
    }

    public static int[] makePath(int[] parent) {
        int cur = n;
        List<Integer> list = new ArrayList<>();
        list.add(cur);
        while (cur != 1) {
            cur = parent[cur];
            list.add(cur);
        }

        int[] path = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            path[i] = list.get(i);
        }
        return path;
    }

    public static Pair diijkstra(List<Node>[] graph, int edgeFrom, int edgeTo) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX_DIST);
        dist[1] = 0; // 1 -> 1
        int[] path = new int[n + 1];

        pq.clear();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            int minIdx = pq.peek().idx;
            int minDist = pq.peek().dist;
            pq.poll();

            if (minDist < dist[minIdx]) continue;

            for (Node next : graph[minIdx]) {
                int targetIdx = next.idx;

                if ((minIdx == edgeFrom && targetIdx == edgeTo) || (minIdx == edgeTo && targetIdx == edgeFrom)) {
                    continue;
                }

                int newDist = minDist + next.dist;
                if (newDist < dist[targetIdx]) {
                    dist[targetIdx] = newDist;
                    path[targetIdx] = minIdx; // minIdx -> targetIdx
                    pq.add(new Node(targetIdx, newDist));
                }
            }
        }
        return new Pair(dist, path);
    }
}