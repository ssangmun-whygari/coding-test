import java.util.*;
public class Main {
    public static int[] values;
    public static List<Integer>[] edges;
    public static boolean[] visited;
    public static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }

        visited = new boolean[n + 1];
        dp = new int[n + 1][2][2]; // dp[i][j][k] : i번이 서브트리의 루트일때, j : i번 선택 여부(1 : 선택/0 : 미선택), k : 부모 선택 여부(1 : 선택/0 : 미선택)
        visited[1] = true;
        dfs(1);

        int ans = dp[1][0][0];
        ans = Math.max(ans, dp[1][1][0]);
        ans = Math.max(ans, dp[1][1][1]);
        System.out.print(ans);
    }

    public static void dfs(int cur) {
        int v1 = values[cur]; // 자신 선택시 자기 자식은 다 고르면 안됨
        int v2 = 0; // 자신을 선택하지 않기로 했을 때, 부모가 선택되었다면, 자기 자식 중 반드시 하나를 골라야 한다는 제약이 없어짐
        int v3 = 0; // 자신을 선택하지 않기로 할 시, 부모도 선택이 안되었다면 자기 자식 중 적어도 하나는 골라야 함

        int minDiff = Integer.MAX_VALUE;
        boolean childSelect = false;
        int childCount = 0;
        for (int next : edges[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            childCount++;
            dfs(next);
            v1 += dp[next][0][1];
            v2 += Math.max(dp[next][0][0], dp[next][1][0]);

            if (dp[next][0][0] <= dp[next][1][0]) { 
                childSelect = true; // 자식이 큰 값이라서 고르는 게 유리하다.
                v3 += dp[next][1][0];
            } else {
                minDiff = Math.min(dp[next][0][0] - dp[next][1][0], minDiff);
                v3 += dp[next][0][0];
            }
        }

        if (childCount == 0) { // 리프 노드
            v3 = (int) (1e9) * -1;
        }
        if (childCount > 0 && childSelect == false) {
            v3 -= minDiff;
        }

        dp[cur][1][0] = v1; // 자기를 고르기로 했으면 부모는 선택되면 안됨
        dp[cur][0][1] = v2; // 자기 선택 X / 부모 선택 O
        dp[cur][0][0] = v3; // 자기 선택 X / 부모 선택 X
    }
}