import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt() * -1);
        }

        while (M-- > 0) {
            int max = pq.poll() * -1;
            max--;
            pq.add(max * -1);
        }

        System.out.print(pq.peek() * -1);
    }
}