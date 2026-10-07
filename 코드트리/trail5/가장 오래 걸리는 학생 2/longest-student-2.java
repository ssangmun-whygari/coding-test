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
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt();

        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1; // 장소 번호
            int b = sc.nextInt() - 1; // 장소 번호
            int d = sc.nextInt(); // 거리
            graph[b].add(new Node(a, d));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, MAX_DIST);
        dist[n - 1] = 0; // 학교에서 학교로 가는 거리

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n - 1, 0));
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

        System.out.println(Arrays.stream(dist).max().orElse(0));
    }
}