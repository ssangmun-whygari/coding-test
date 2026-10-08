import java.util.*;

class Node implements Comparable<Node> {
    public int x, y;
    public int dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}

public class Main {
    public static int MAX_DIST = (int) 1e9;
    public static int n;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[][] brackets = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                brackets[i][j] = row.charAt(j);
            }
        }

        List<Node>[][] graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = new ArrayList<Node>();

        int[] dx = new int[] {-1, 0, 0, 1};
        int[] dy = new int[] {0, -1, 1, 0};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (!inRange(nx, ny)) continue;
                    int dist = (brackets[i][j] == brackets[nx][ny]) ? a : b;
                    graph[i][j].add(new Node(nx, ny, dist));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diijkstra(i, j, graph);
            }
        }

        System.out.print(ans);
    }

    public static void diijkstra(int startX, int startY, List<Node>[][] graph) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], MAX_DIST);
        dist[startX][startY] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, 0));
        while (!pq.isEmpty()) {
            int minX = pq.peek().x;
            int minY = pq.peek().y;
            int minDist = pq.peek().dist;
            pq.poll();

            if (minDist > dist[minX][minY]) continue;

            for (Node next : graph[minX][minY]) {
                int targetX = next.x;
                int targetY = next.y;
                int newDist = dist[minX][minY] + next.dist;
                if (newDist < dist[targetX][targetY]) {
                    dist[targetX][targetY] = newDist;
                    pq.add(new Node(targetX, targetY, newDist));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dist[i][j]);
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}