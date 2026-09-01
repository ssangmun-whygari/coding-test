import java.util.*;

class Node {
    public int no;
    public Node prev;
    public Node next;
    Node(int no) {
        this.no = no;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        // 연결리스트 만들기
        Node[] nodeArr = makeNodeArr(n);

        // print(nodeArr);
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            swap(nodeArr, a, b, c, d);
            // print(nodeArr);
        }

        print(nodeArr);
    }

    public static void print(Node[] nodeArr) {
        Node head = null;

        for (int i = 1; i < nodeArr.length; i++) {
            if (nodeArr[i].prev == null) {
                head = nodeArr[i];
                break;
            }
        }

        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.no + " ");
            cur = cur.next;
        }
        System.out.println(sb);
    }

    public static void connect(Node[] nodeArr, Node n1, Node n2) {
        // n1이 n2보다 앞에 있음
        if (n1 != null) {
            n1.next = n2;
        }
        if (n2 != null) {
            n2.prev = n1;
        }
    }

    public static void swap(Node[] nodeArr, int a, int b, int c, int d) {
        Node s1 = nodeArr[a];
        Node e1 = nodeArr[b];
        Node s2 = nodeArr[c];
        Node e2 = nodeArr[d];
        if (nodeArr[b].next == nodeArr[c] && nodeArr[c].prev == nodeArr[b]) {
            // -- E0 -- s2 --- e2 -- s1 --- e1 -- S1 --
            Node E0 = s1.prev;
            Node S1 = e2.next;

            connect(nodeArr, E0, s2);
            connect(nodeArr, e2, s1);
            connect(nodeArr, e1, S1);
        } else if (nodeArr[d].next == nodeArr[a] && nodeArr[a].prev == nodeArr[d]) {
            Node E0 = s2.prev;
            Node S1 = e1.next;

            connect(nodeArr, E0, s1);
            connect(nodeArr, e2, S1);
            connect(nodeArr, e1, s2);
        } else {
            // -- E0 -- s2 --- e2 -- S1 --- E1 -- s1 --- e1 -- S2 --
            Node E0 = s1.prev;
            Node S1 = e1.next;
            Node E1 = s2.prev;
            Node S2 = e2.next;

            connect(nodeArr, E0, s2);
            connect(nodeArr, e2, S1);
            connect(nodeArr, E1, s1);
            connect(nodeArr, e1, S2);
        }
    }

    public static Node[] makeNodeArr(int n) {
        Node[] nodeArr = new Node[n + 1]; // 1 ~ n

        for (int i = 1; i <= n; i++) {
            nodeArr[i] = new Node(i);
        }

        // 연결관계를 만들어준다.
        for (int i = 1; i < n; i++) {
            nodeArr[i].next = nodeArr[i + 1];
            nodeArr[i + 1].prev = nodeArr[i];
        }

        return nodeArr;
    }
}