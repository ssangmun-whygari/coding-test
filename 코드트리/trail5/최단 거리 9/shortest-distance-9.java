import java.util.*;

class Node implements Comparable<Node> {
    public int idx;
    public long dist;

    Node(int idx, long dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(this.dist, other.dist);
    }
}

public class Main {
    public static long MAX_DIST = (long) 2e10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수

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
        
        long[] dist = new long[n];
        Arrays.fill(dist, MAX_DIST);
        dist[a] = 0; // a에서 a로 가는 거리는 0
        int[] path = new int[n];
        path[a] = a; // a의 직전 정점은 a

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int minIdx = cur.idx;
            long minDist = cur.dist;

            if (minDist > dist[minIdx]) {
                continue;
            }

            for (Node next : graph[minIdx]) {
                int targetIdx = next.idx;
                long newDist = minDist + next.dist;
                if (newDist < dist[targetIdx]) {
                    path[targetIdx] = minIdx; // minIdx -> targetIdx
                    dist[targetIdx] = newDist;
                    pq.add(new Node(targetIdx, newDist));
                }
            }
        }

        List<Integer> vertices = new ArrayList<>();
        vertices.add(b);
        int idx = b;
        while (idx != a) {
            idx = path[idx];
            vertices.add(idx);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[b] + "\n");
        for (int i = vertices.size() - 1; i >= 0; i--) {
            int v = vertices.get(i);
            sb.append((v + 1) + " ");
        }
        System.out.println(sb.toString());
    }
}