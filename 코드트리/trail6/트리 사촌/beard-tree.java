import java.util.*;

class Node {
    public Node parent;
    public List<Node> children = new ArrayList<>();
    public int id;

    Node(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Node[] arr = new Node[n];
        Node target = null;
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            arr[i] = new Node(id);
            if (id == k) target = arr[i];
        }

        int curIdx = 1;
        int pIdx = 0;
        Node parent = arr[pIdx];

        while (curIdx < n) {
            // arr[curIdx].id + 1, arr[curIdx + 1].id
            while (curIdx + 1 < n && arr[curIdx].id + 1 == arr[curIdx + 1].id) {
                linkChild(parent, arr[curIdx]);
                curIdx++;
            }
            if (curIdx < n) {
                linkChild(parent, arr[curIdx]);
            }

            curIdx++;
            if (curIdx < n) {
                parent = arr[++pIdx];
            }
        }

        int ans = 0;
        if (target.parent != null && target.parent.parent != null) {
            Node grandParent = target.parent.parent;
            for (Node p : grandParent.children) {
                if (p != target.parent) { // 형제는 제외
                    for (Node child : p.children) {
                        ans++;
                    }
                }
            }
        }

        System.out.print(ans);
    }

    public static void linkChild(Node parent, Node child) {
        parent.children.add(child);
        child.parent = parent;
    }
}