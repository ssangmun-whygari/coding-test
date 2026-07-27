import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            
            if ("push_front".equals(cmd)) {
                int arg = sc.nextInt();
                list.addFirst(arg);
            } else if ("push_back".equals(cmd)) {
                int arg = sc.nextInt();
                list.addLast(arg);
            } else if ("pop_front".equals(cmd)) {
                System.out.println(list.pollFirst());
            } else if ("pop_back".equals(cmd)) {
                System.out.println(list.pollLast());
            } else if ("size".equals(cmd)) {
                System.out.println(list.size());
            } else if ("empty".equals(cmd)) {
                if (list.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("front".equals(cmd)) {
                System.out.println(list.peekFirst());
            } else if ("back".equals(cmd)) {
                System.out.println(list.peekLast());
            }
        }
    }
}