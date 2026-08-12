import java.util.*;
public class Main {
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new boolean[n + 1]; // 1 ~ n
        List<Integer> perm = new ArrayList<>();
        recur(perm);
    }

    public static void recur(List<Integer> perm) {
        if (perm.size() == n) {
            for (int i : perm) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm.add(i);
            recur(perm);
            visited[i] = false;
            perm.remove(perm.size() - 1);
        }
    }
}