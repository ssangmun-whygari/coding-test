import java.util.*;
public class Main {
    public static boolean isTree = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> node = new HashSet<>();
        List<Integer>[] graph = new ArrayList[10000 + 1];
        for (int i = 1; i <= 10000; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            node.add(u);
            node.add(v);
        }

        Set<Integer> root_cand = new HashSet<>(node);
        for (int u : node) {
            for (int child : graph[u]) {
                root_cand.remove(child);
            }
        }
        if (root_cand.size() != 1) {
            isTree = false;
        }
        check();

        int root = -1;
        for (int i : root_cand) {  // root_cand에는 1개밖에 없음
            root = i;
        }
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int x : node) {
            visited.put(x, false);
        }

        traverse(root, graph, visited);
        check();

        // 모든 노드를 방문했는가?
        for (int key : visited.keySet()) {
            if (visited.get(key) == false) {
                isTree = false;
                break;
            }
        }
        check();

        System.out.print(1);
    }

    public static void traverse(int x, List<Integer>[] graph, Map<Integer, Boolean> visited) {
        if (!isTree) return;

        if (visited.get(x) == false) {
            visited.put(x, true);
        } else {
            isTree = false;
            return;
        }

        for (int child : graph[x]) {
            traverse(child, graph, visited);
        }
    }

    public static void check() {
        if (isTree == false) {
            System.out.print(0);
            System.exit(0);
        }
    }
}