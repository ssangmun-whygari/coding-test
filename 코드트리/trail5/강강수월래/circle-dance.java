import java.util.*;

class Node {
    public int data;
    public Node prev, next;
    Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static Map<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int count = sc.nextInt();
            Node before = null, cur = null;
            Node head = null;
            for (int j = 0; j < count; j++) {
                int no = sc.nextInt();
                cur = new Node(no);
                map.put(no, cur);
                if (j == 0) {
                    head = cur;
                }
                if (before != null) {
                    // before에서 시계방향으로 돌렸을 때 cur가 있음
                    // 반시계방향을 next로 정의했으므로
                    before.prev = cur;
                    cur.next = before;
                }
                before = cur;
            }
            // cur의 시계방향에 head가 있음
            cur.prev = head;
            head.next = cur; // 원형 연결 리스트 완성
        }
        
        for (int i = 0; i < Q; i++) {
            int cmd = sc.nextInt();
            int A = 0, B = 0;
            switch (cmd) {
                case 1:
                    A = sc.nextInt();
                    B = sc.nextInt();
                    connectCircle(A, B);
                break;
                case 2:
                    A = sc.nextInt();
                    B = sc.nextInt();
                    divideCircle(A, B);
                break;
                case 3:
                    A = sc.nextInt();
                    printCircle(A);
                break;
            }
        }
    }

    public static void connect(Node x, Node y) {
        if (x != null) {
            x.next = y;
        }
        if (y != null) {
            y.prev = x;
        }
    }

    public static void connectCircle(int A, int B) {
        Node nodeA = map.get(A);
        Node nodeB = map.get(B);

        Node before_nodeA_prev = nodeA.prev;
        Node before_nodeB_next = nodeB.next;

        connect(nodeB, nodeA);
        connect(before_nodeA_prev, before_nodeB_next);
    }

    public static void divideCircle(int A, int B) {
        Node nodeA = map.get(A);
        Node nodeB = map.get(B);
        Node before_nodeA_next = nodeA.next;

        connect(nodeA, nodeB.next);
        connect(nodeB, before_nodeA_next);
    }

    public static void printCircle(int A) {
        Node nodeA = map.get(A);

        // 가장 작은 번호의 노드 찾기
        Node cur = nodeA;
        int minValue = Integer.MAX_VALUE;
        Node minNode = null;
        while (true) {
            if (cur.data < minValue) {
                minNode = cur;
                minValue = minNode.data;
            }
            cur = cur.next;
            if (cur == nodeA) break;
        }

        // 찾은 노드부터 순회하기
        StringBuilder sb = new StringBuilder();
        cur = minNode;
        while (true) {
            sb.append(cur.data + " ");
            cur = cur.next;
            if (cur == minNode) break;
        }
        sb.append("\n");

        System.out.print(sb.toString());
    }
}