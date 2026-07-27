import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String cmd = sc.next();
            if ("push".equals(cmd)) {
                int arg = sc.nextInt();
                stack.push(arg);
            } else if ("pop".equals(cmd)) {
                System.out.println(stack.pop());
            } else if ("size".equals(cmd)) {
                System.out.println(stack.size());
            } else if ("empty".equals(cmd)) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("top".equals(cmd)) {
                System.out.println(stack.peek());
            }
        }
    }
}