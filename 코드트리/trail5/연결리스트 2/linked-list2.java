import java.util.*;

class Node {
    public int no;
    public Node prev, next;
    Node(int no) {
        this.no = no;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new Node(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < Q; k++) {
            int cmd = sc.nextInt();
            int i = 0, j = 0;
            Node iNode = null, jNode = null;
            switch (cmd) {
                case 1:
                    int no = sc.nextInt();
                    Node node = map.get(no);
                    // node를 뽑아서 단일 노드가 되게 함
                    if (node.prev != null) {
                      node.prev.next = node.next;
                    }
                    if (node.next != null) {
                      node.next.prev = node.prev;
                    }
                    node.prev = null;
                    node.next = null;
                break;
                case 2:
                    i = sc.nextInt();
                    j = sc.nextInt();
                    iNode = map.get(i);
                    jNode = map.get(j);
                    
                    // jNode를 iNode 앞에 삽입
                    jNode.next = iNode;
                    jNode.prev = iNode.prev;

                    if (jNode.prev != null) {
                        jNode.prev.next = jNode;
                    }
                    if (jNode.next != null) {
                        jNode.next.prev = jNode;
                    }
                break;
                case 3:
                    i = sc.nextInt();
                    j = sc.nextInt();
                    iNode = map.get(i);
                    jNode = map.get(j);
                    
                    // jNode를 iNode 뒤에 삽입
                    jNode.next = iNode.next;
                    jNode.prev = iNode;

                    if (jNode.prev != null) {
                        jNode.prev.next = jNode;
                    }
                    if (jNode.next != null) {
                        jNode.next.prev = jNode;
                    }
                break;
                case 4:
                    i = sc.nextInt();
                    iNode = map.get(i);
                    sb.append(String.format("%d %d\n", 
                        iNode.prev == null ? 0 : iNode.prev.no,
                        iNode.next == null ? 0 : iNode.next.no
                    ));
                break;
            }
        }

        for (int i = 1; i <= N; i++) {
            Node node = map.get(i);
            Node nextNode = map.get(i).next;
            sb.append(nextNode == null ? 0 : nextNode.no);
            sb.append(' ');
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }
}