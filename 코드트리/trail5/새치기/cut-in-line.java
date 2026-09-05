import java.util.*;

class Node {
    public int data;
    public int lineNum;
    public Node prev, next;
    Node(int lineNum, int data) {
        this.lineNum = lineNum;
        this.data = data;
    }
}

public class Main {
    public static int N;
    public static int M; // 줄의 수

    public static Node[] heads;
    public static Node[] tails;
    public static Map<Integer, Node> nodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int Q = sc.nextInt();
        heads = new Node[N + 1]; // 1 ~ N번 줄의 head
        tails = new Node[N + 1]; // 1 ~ N번 줄의 tail

        for (int i = 1; i <= M; i++) {
            int n = sc.nextInt();
            Node prev = null, node = null;
            for (int j = 0; j < n; j++) {
                node = new Node(i, sc.nextInt());
                nodes.put(node.data, node);
                if (prev != null) {
                    prev.next = node;
                    node.prev = prev;
                }
                if (j == 0) {
                    heads[i] = node;
                }
                if (j == n - 1) {
                    tails[i] = node;
                }
                prev = node;
            }
        }

        while (Q-- > 0) {
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1:
                    cmd1(nodes.get(sc.nextInt()), nodes.get(sc.nextInt()));
                break;
                case 2:
                    cmd2(nodes.get(sc.nextInt()));
                break;
                case 3:
                    cmd3(nodes.get(sc.nextInt()), nodes.get(sc.nextInt()), nodes.get(sc.nextInt()));
                break;
            }
        }

        printLines();
    }

    public static void printLines() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            Node head = heads[i];
            if (head == null) {
                sb.append(-1 + "\n");
                continue;
            }
            Node cur = head;
            while (cur != null) {
                sb.append(cur.data + " ");
                cur = cur.next;
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void pop(Node x) {
        if (x.prev != null) {
            x.prev.next = x.next; // x.next는 null일 수 있음
        }
        if (x.next != null) {
            x.next.prev = x.prev; // x.prev는 null일 수 있음
        }
        x.prev = x.next = null;
    }

    public static void connect(Node x, Node y) {
        if (x != null)
            x.next = y;
        if (y != null)
            y.prev = x;
    }
    
    public static void cmd1(Node a, Node b) {
        // a 노드가 b 노드 앞으로 새치기를 함

        if (a == heads[a.lineNum]) {
            heads[a.lineNum] = a.next;
        } else if (a == tails[a.lineNum]) {
            tails[a.lineNum] = a.prev;
        }
        a.lineNum = b.lineNum; // a가 b가 속한 줄로 이동했음
        if (b == heads[b.lineNum]) {
            heads[b.lineNum] = a;
        }

        pop(a);
        connect(b.prev, a);
        connect(a, b);
    }

    public static void cmd2(Node a) {
        pop(a);
        if (heads[a.lineNum] == a) {
            heads[a.lineNum] = a.next;
        }
        if (tails[a.lineNum] == a) {
            tails[a.lineNum] = a.prev;
        }
    }

    public static void cmd3(Node a, Node b, Node c) {
        if (a == heads[a.lineNum]) {
            heads[a.lineNum] = b.next;
        }
        if (b == tails[b.lineNum]) {
            tails[b.lineNum] = a.prev;
        }

        // a ~ b까지 소속된 줄을 변경
        Node cur = a;
        while (cur != b) {
            cur.lineNum = c.lineNum;
            cur = cur.next;
        }
        
        cur.lineNum = c.lineNum;
        if (c == heads[c.lineNum]) {
            heads[c.lineNum] = a;
        }

        // a ~ b 의 사람이 c 앞으로 새치기함
        if (a.prev != null) {
            a.prev.next = b.next; // b.next가 null일 수 있음
        }
        if (b.next != null) {
            b.next.prev = a.prev;// a.prev가 null일 수 있음
        }
        a.prev = null; b.next = null;

        connect(c.prev, a);
        connect(b, c);
    }

}