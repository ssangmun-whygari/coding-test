import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            pq.add(arr[i] * -1);

        while (pq.size() > 1) {
            int first = pq.poll() * -1;
            int second = pq.poll() * -1;

            if (first != second) {
                pq.add( (first - second) * -1);
            }
        }

        System.out.print(pq.isEmpty() ? -1 : pq.poll() * -1);
    }
}