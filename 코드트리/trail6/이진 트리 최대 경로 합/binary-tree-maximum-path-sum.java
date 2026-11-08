import java.util.*;
import java.io.*;

class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static List<Integer>[] edges;
    public static boolean[] visited;
    public static int[][] dp;
    public static int[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        visited[1] = true;
        dfs(1);

        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }

        System.out.print(maxVal);
    }

    public static Pair dfs(int cur) {
        int result = a[cur];

        int childCount = 0;
        int leftVal = Integer.MIN_VALUE;
        int rightVal = Integer.MIN_VALUE;

        for (int next : edges[cur]) {
            if (visited[next]) continue;
            visited[next] = true;

            childCount++;
            int child = dfs(next).a;

            if (childCount == 1) {
                leftVal = child;
            } else if (childCount == 2) {
                rightVal = child;
            }
        }

        if (leftVal > 0 && rightVal > 0) {
            dp[cur][1] = (result + leftVal + rightVal);
        } else {
            dp[cur][1] = result;
        }
        if (childCount >= 1) {
            int bigger = Math.max(leftVal, rightVal);
            if (bigger > 0) {
                dp[cur][0] = (result + bigger);
            } else {
                dp[cur][0] = result;
            }
        } else if (childCount == 0) { // 리프 노드
            dp[cur][0] = result;
            dp[cur][1] = result;
        }

        return new Pair(dp[cur][0], dp[cur][1]);
    }

}