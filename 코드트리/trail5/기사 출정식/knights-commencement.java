import java.util.*;

class Node {
    public int value;
    public Node next; // 자기 왼쪽에 있는 노드
    public Node prev;  // 자기 오른에 있는 노드
    
    Node(int value) {
        this.value = value;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Map<Integer, Node> knights = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Node prev = null, cur = null;
        Node head = null;
        for (int i = 0; i < N; i++) {
            int no = sc.nextInt();
            cur = new Node(no);
            knights.put(no, cur);

            if (i == 0) {
                head = cur;
            }

            connect(prev, cur);
            prev = cur;
        }

        connect(cur, head);

        int[] calls = new int[M];
        for (int i = 0; i < M; i++) {
            calls[i] = sc.nextInt();
        }

        for (int call : calls) {
            Node knight = knights.get(call);
            sb.append(knight.next.value + " " + knight.prev.value + "\n");
            pop(knight);
        }

        System.out.print(sb.toString());
    }

    public static void connect(Node n1, Node n2) {
        if (n1 != null) {
            n1.next = n2;
        }
        if (n2 != null) {
            n2.prev = n1;
        }
    }

    public static void pop(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
        knights.remove(node);
    }
}