import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        double total = 0.0;
        double maxAvg = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[n - 1]);
        pq.add(arr[n - 2]);
        total += arr[n - 1];
        total += arr[n - 2];
        maxAvg = Math.max(maxAvg, getAvg(total, pq));
        
        for (int i = n - 3; i >= 0; i--) {
            pq.add(arr[i]);
            total += arr[i];
            maxAvg = Math.max(maxAvg, getAvg(total, pq));
        }
        
        System.out.printf("%.2f", maxAvg);
    }

    public static double getAvg(double total, PriorityQueue<Integer> pq) {
        int excepted = pq.peek();
        total = total - excepted; // 가장 작은 수 제외
        return total / (pq.size() - 1);
    }
}