import java.util.*;

class Node {
    public int idx;
    public int value;

    Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node<idx: " + idx + ", val: " + value + ">";
    }
}


public class Main {
    public static List<Node>[] graph;
    public static Node[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }
        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, 0);
        }

        for (int i = 2; i <= n; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int p = sc.nextInt();

            int value = (t == 1) ? a : -1 * a;
            Node node = nodes[i];
            node.value = value;
            graph[p].add(node);
        }
        // System.out.print(Arrays.toString(nodes));

        int ans = recur(1);
        System.out.print(ans);
    }

    public static int recur(int cur) {
        int value = nodes[cur].value;
        for (Node child : graph[cur]) {
            int childVal = recur(child.idx);
            if (childVal > 0) {
                value += childVal;
            }
        }
        return value;
    }


}