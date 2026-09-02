import java.util.*;

class Node {
    public String data;
    public Node prev, next;
    Node(String data) {
        this.data = data;
    }
}

public class Main {
    public static Node head = null;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        Node prev = null, cur = null;
        for (int i = 0; i < N; i++) {
            String city = sc.next();
            if (i == 0) {
                head = new Node(city);
                prev = head;
            } else {
                cur = new Node(city);
                prev.next = cur;
                cur.prev = prev;
                prev = cur;
            }
        }
        cur.next = head;
        head.prev = cur;

        while (Q-- > 0) {
            int cmd = sc.nextInt();
            switch (cmd) {
                case 1:
                    if (head.next != null) {
                        head = head.next;
                    }
                break;
                case 2:
                    if (head.prev != null) {
                        head = head.prev;
                    }
                break;
                case 3:
                    popNext(head);
                break;
                case 4:
                    pushNext(new Node(sc.next()));
                break;
            }
            // printAllNodes();
            sb.append(printAdjNode());
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void printAllNodes() {
        if (head.next == null) {
            System.out.println("노드가 없습니다.");
            return;
        }

        Node temp = head;
        while (true) {
            System.out.print(head.data + " ");
            head = head.next;
            if (head == temp) break;
        }
        System.out.println();
    }

    public static String printAdjNode() {
        if (head.next == null || head.next.data.equals(head.prev.data)) {
            return "-1";
        } else {
            return head.prev.data + " " + head.next.data;
        }
    }

    public static void pushNext(Node newNode) {
        if (head.next == null) {
            // 리스트에 head 하나밖에 없었음
            head.next = newNode;
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = head;

            // head = newNode; // head를 변경
        } else {
            head.next.prev = newNode;
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;

            // head = newNode; // head를 변경
        }
    }
    
    public static Node popNext(Node cur) {
        // 현재 도시의 오른쪽 제거
        if (cur.next == null) {
            return null;
        }

        Node target = cur.next;
        if (target.next == cur) { 
            // 연결 리스트에 2개밖에 없음.
            cur.next = null;
            cur.prev = null;
            target.prev = null;
            target.next = null;

            return target;
        } else {
            cur.next = target.next;
            target.next.prev = cur;

            target.next = null;
            target.prev = null;

            return target;
        }
    }
}