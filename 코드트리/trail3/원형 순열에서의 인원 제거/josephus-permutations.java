import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            // K번째 사람까지 이동한다.
            for (int i = 0; i < k - 1; i++) {
                q.add(q.peek());
                q.poll();
            }

            // K번째 사람을 제거한다.
            System.out.print(q.poll() + " ");
        }
    }
}