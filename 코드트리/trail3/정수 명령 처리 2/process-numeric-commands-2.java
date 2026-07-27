import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if ("push".equals(cmd)) {
                q.add(sc.nextInt());
            } else if ("pop".equals(cmd)) {
                System.out.println(q.poll());
            } else if ("size".equals(cmd)) {
                System.out.println(q.size());
            } else if ("empty".equals(cmd)) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("front".equals(cmd)) {
                System.out.println(q.peek());
            }
        }
    }
}