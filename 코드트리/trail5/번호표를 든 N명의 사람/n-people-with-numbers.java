import java.util.*;
public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tMax = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        int left = 1;
        int right = n;
        int ans = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid, d, tMax)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }

    public static boolean is_possible(int k, int[] d, int tMax) {
        // k명까지 무대에 올린다
        pq.clear();
        for (int i = 0; i < k; i++) {
            pq.add(d[i]);
        }

        int elapsed = 0;
        int idx_d = k;
        while (idx_d < d.length) {
            int person = pq.poll();
            elapsed = person;
            pq.add(d[idx_d++] + person);
        }
        while (!pq.isEmpty()) {
            int person = pq.poll();
            elapsed = person;
        }

        return elapsed <= tMax;
    }
}