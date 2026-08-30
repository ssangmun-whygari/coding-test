import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int max;
            String cmd = sc.next();
            switch (cmd) {
                case "push":
                    int param = sc.nextInt();
                    pq.add(-param);
                break;
                case "pop":
                    max = pq.poll() * -1;
                    System.out.println(max);
                break;
                case "size":
                    System.out.println(pq.size());
                break;
                case "empty":
                    System.out.println(pq.isEmpty() ? 1 : 0);
                break;
                case "top":
                    max = pq.peek() * -1;
                    System.out.println(max);
                break;
            }
        }
    }
}