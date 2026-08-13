import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N + 1]; // 1 ~ N

        List<Integer> picked = new ArrayList<>();
        recur(picked);
    }

    public static void recur(List<Integer> picked) {
        if (picked.size() == N) {
            for (int num : picked) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = N; i >= 1; i--) {
            if (visited[i]) continue;
            visited[i] = true;
            picked.add(i);
            recur(picked);
            visited[i] = false;
            picked.remove(picked.size() - 1);
        }
    }
}