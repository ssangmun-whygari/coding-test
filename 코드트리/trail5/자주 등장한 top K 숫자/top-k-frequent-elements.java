import java.util.*;

class Node implements Comparable<Node> {
    public int value = 0;
    public int count = 0;
    Node(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Node other) {
        if (this.count == other.count) {
            return Integer.compare(other.value, this.value);
        } else {
            return Integer.compare(other.count, this.count);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Node> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                Node node = map.get(i);
                node.count += 1;
            } else {
                Node node = new Node(i, 0);
                map.put(i, node);
            }
        }

        List<Node> nodes = new ArrayList<>(map.values());
        Collections.sort(nodes);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(nodes.get(i).value + " ");
        }
        System.out.print(sb);
    }
}