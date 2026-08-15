import java.util.*;

class Node {
    public int val, step;
    Node(int val, int step) {
        this.val = val;
        this.step = step;
    }
}

public class Main {
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        visited = new boolean[1000001]; // 1 ~ 1,000,000

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 0));
        int limit = 1000000;
        int ans = 0;
        while (limit-- > 0) {
            Node cur = queue.poll();

            if (cur.val == N) {
                ans = cur.step;
                break;
            }

            if (canGo(cur.val + 1)) {
                visited[cur.val + 1] = true;
                queue.add(new Node(cur.val + 1, cur.step + 1));
            }
            if (canGo(cur.val - 1)) {
                visited[cur.val - 1] = true;
                queue.add(new Node(cur.val - 1, cur.step + 1));
            }
            if (canGo(cur.val * 2)) {
                visited[cur.val * 2] = true;
                queue.add(new Node(cur.val * 2, cur.step + 1));
            }
            if (canGo(cur.val * 3)) {
                visited[cur.val * 3] = true;
                queue.add(new Node(cur.val * 3, cur.step + 1));
            }
        }
        System.out.print(ans);
    }

    public static boolean canGo(int x) {
        return x >= 1 && x <= 1000000 && visited[x] == false;
    }
}