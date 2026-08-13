import java.util.*;

public class Main {
    public static int[][] cost;
    public static boolean[] visited;
    public static int ans = Integer.MAX_VALUE;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n]; // 0 ~ n - 1

        recur(1, 0, 0);
        System.out.println(ans);
    }

    public static void recur(int cnt, int lastVisited, int costSum) {
        if (cnt == n) {
            if (cost[lastVisited][0] == 0) return;
            costSum += cost[lastVisited][0]; // 0번 지점으로 돌아옴
            ans = Math.min(ans, costSum);
            return;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (visited[i]) continue;
            if (cost[lastVisited][i] == 0) continue; // 거리가 0이면 이동 못함을 뜻함
            visited[i] = true;
            recur(cnt + 1, i, costSum + cost[lastVisited][i]);
            visited[i] = false;
        }
    }
}