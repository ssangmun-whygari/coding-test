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
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int sumCost = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = pq.poll();
            int b = pq.poll();

            sumCost += (a + b);

            pq.add(a + b);
        }

        System.out.print(sumCost);
    }
}