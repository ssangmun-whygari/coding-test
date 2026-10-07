import java.util.*;

class Element implements Comparable<Element> {
    public int to, w;

    Element(int to, int weight) {
        this.to = to;
        this.w = weight;
    }

    @Override
    public int compareTo(Element other) {
        return Integer.compare(this.w, other.w);
    }
}

public class Main {
    public static int MAX_DIST = (int) 1e9; // 10억

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;

        List<Element>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Element>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            graph[u].add(new Element(v, w));
            graph[v].add(new Element(u, w));
        }

        int[] dist = new int[n]; // dist[x] : k번 정점에서 x번까지의 최단 거리
        Arrays.fill(dist, MAX_DIST);
        dist[k] = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(k, 0));
        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            int minIdx = cur.to;
            int minDist = cur.w;

            if (dist[minIdx] < minDist) {
                continue;
            }

            for (Element next : graph[minIdx]) {
                int targetIdx = next.to;
                int targetDist = next.w;

                if (minDist + targetDist < dist[targetIdx]) {
                    dist[targetIdx] = minDist + targetDist;
                    pq.add(new Element(targetIdx, dist[targetIdx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dist[i] == MAX_DIST ? -1 : dist[i]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}