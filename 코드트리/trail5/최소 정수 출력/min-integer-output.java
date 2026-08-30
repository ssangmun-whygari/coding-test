import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            if (num > 0) {
                pq.add(num);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll() + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.print(sb);
    }
}