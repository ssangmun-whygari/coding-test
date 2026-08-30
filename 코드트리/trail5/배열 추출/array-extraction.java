import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 0) {
                pq.add(-x);
            } else if (!pq.isEmpty()) {
                System.out.println(pq.poll() * -1);
            } else {
                System.out.println(0);
            }
        }
    }
}