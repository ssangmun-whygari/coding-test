import java.util.*;

class Node {
    public String value;
    public Node prev;
    public Node next;

    Node(String value) {
        this.value = value;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node cur = new Node(sc.next());
        int N = sc.nextInt();

        String value = null;
        Node newNode = null;

        for (int i = 0; i < N; i++) {
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1:
                    value = sc.next();
                    newNode = new Node(value);
                    insertPrev(cur, newNode);
                break;
                case 2:
                    value = sc.next();
                    newNode = new Node(value);
                    insertNext(cur, newNode);
                break;
                case 3:
                    if (cur.prev != null) {
                        cur = cur.prev;
                    }
                break;
                case 4:
                    if (cur.next != null) {
                        cur = cur.next;
                    }
                break;
            }
            print(cur);
        }
        System.out.print(sb.toString());
    }

    public static void print(Node cur) {
        sb.append(String.format("%s %s %s\n", 
            cur.prev == null ? "(Null)" : cur.prev.value, 
            cur.value,
            cur.next == null ? "(Null)" : cur.next.value
        ));
    }

    public static void insertPrev(Node cur, Node node) {
        node.next = cur;
        node.prev = cur.prev;
        if (node.next != null) {
            node.next.prev = node;
        }
        if (node.prev != null) {
            node.prev.next = node;
        }
    }

    public static void insertNext(Node cur, Node node) {
        node.prev = cur;
        node.next = cur.next;
        if (node.prev != null) {
            node.prev.next = node;
        }
        if (node.next != null) {
            node.next.prev = node;
        }
    }
}