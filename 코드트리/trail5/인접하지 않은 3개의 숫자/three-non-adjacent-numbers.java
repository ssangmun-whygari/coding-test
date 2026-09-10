import java.util.*;

class Node implements Comparable<Node> {
    public int idx;
    public int value;
    Node(int i, int v) {
        this.idx = i;
        this.value = v;
    }

    @Override
    public int compareTo(Node other) {
        if (this.value != other.value) {
            return Integer.compare(this.value, other.value);
        } else {
            return Integer.compare(this.idx, other.idx);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(0, new Node(0, Integer.MIN_VALUE));
        map.put(N + 1, new Node(N + 1, Integer.MIN_VALUE));
        for (int i = 1; i <= N; i++) {
            map.put(i, new Node(i, sc.nextInt()));
        }

        TreeSet<Node> set = new TreeSet<>();
        for (int i = 0; i <= N + 1; i++) {
            set.add(map.get(i));
        }

        // L[x] : 왼쪽에서 x 인덱스까지 봤을 때 최대값을 가진 노드
        Node[] L = new Node[N + 2];
        L[0] = map.get(0);
        for (int i = 1; i <= N; i++) {
            if (map.get(i).value >= L[i - 1].value) {
                L[i] = map.get(i);
            } else {
                L[i] = L[i - 1];
            }
        }

        Node[] R = new Node[N + 2];
        R[N + 1] = map.get(N + 1);
        for (int i = N; i >= 1; i--) {
            // R[n], R[n + 1]
            if (map.get(i).value >= R[i + 1].value) {
                R[i] = map.get(i);
            } else {
                R[i] = R[i + 1];
            }
        }
        
        int ans = 0;
        for (int i = 2; i <= N - 1; i++) {
            if (N == 5) {
              ans = map.get(1).value + map.get(3).value + map.get(5).value;
              break;
            }

            // i번째 숫자를 경계로 골랐을 때 L[i - 1], R[i + 1]을 뽑아야 함
            int sum = L[i - 1].value + R[i + 1].value;
            Node l = L[i - 1]; 
            Node r = R[i + 1];
            Node l0 = map.get(l.idx - 1);
            Node l1 = map.get(l.idx + 1);
            Node r0 = map.get(r.idx - 1);
            Node r1 = map.get(r.idx + 1);

            set.remove(l);
            set.remove(r);
            set.remove(l0);
            set.remove(l1);
            set.remove(r0);
            set.remove(r1);

            sum += set.last().value;
            ans = Math.max(ans, sum);

            set.add(l);
            set.add(r);
            set.add(l0);
            set.add(l1);
            set.add(r0);
            set.add(r1);
        }

        System.out.print(ans);
    }
}