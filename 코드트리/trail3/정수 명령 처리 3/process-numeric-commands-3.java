import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if ("push_front".equals(cmd)) {
                dq.addFirst(sc.nextInt());
            } else if ("push_back".equals(cmd)) {
                dq.addLast(sc.nextInt());
            } else if ("pop_front".equals(cmd)) {
                print(dq.pollFirst());
            } else if ("pop_back".equals(cmd)) {
                print(dq.pollLast());
            } else if ("size".equals(cmd)) {
                print(dq.size());
            } else if ("empty".equals(cmd)) {
                if (dq.isEmpty()) {
                    print(1);
                } else {
                    print(0);
                }
            } else if ("front".equals(cmd)) {
                print(dq.peekFirst());
            } else if ("back".equals(cmd)) {
                print(dq.peekLast());
            }
        }
    }

    public static void print(int a) {
        System.out.println(a);
    }
}