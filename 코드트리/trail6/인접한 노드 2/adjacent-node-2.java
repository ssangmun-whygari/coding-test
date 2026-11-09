import java.util.*;

class Pair {
    public int id;
    public boolean selected;

    Pair(int id, boolean selected) {
        this.id = id;
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", " + selected + "]";
    }
}

public class Main {
    public static int[] a;
    public static List<Integer>[] edges;
    public static boolean[] visited;
    public static List<Pair>[] trace0;
    public static List<Pair>[] trace1;
    public static int[][] dp;
    public static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
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

        trace0 = new ArrayList[n + 1];
        trace1 = new ArrayList[n + 1];


        dp = new int[n + 1][2];

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1);

        // printTrace(trace0);
        // printTrace(trace1);

        // System.out.println("dp[1][0] : " + dp[1][0] + ", dp[1][1] : " + dp[1][1]);

        Arrays.fill(visited, false);
        visited[1] = true;
        if (dp[1][0] < dp[1][1]) {
            selected.add(1);
            trace(true);

            System.out.println(dp[1][1]);
            Collections.sort(selected);
            printSelected();
        } else {
            trace(false);

            System.out.println(dp[1][0]);
            Collections.sort(selected);
            printSelected();
        }
    }

    public static void printSelected() {
        StringBuilder sb = new StringBuilder();
        for (int s : selected) {
            sb.append(s + " ");
        }
        System.out.println(sb.toString());
    }

    public static void trace(boolean root_selected) {
        recur(1, root_selected);
    }

    public static void recur(int cur, boolean cur_selected) {
        List<Pair>[] trace = (cur_selected == true) ? trace1 : trace0;

        for (Pair pair : trace[cur]) {
            int next = pair.id;
            if (visited[next]) continue;
            visited[next] = true;

            if (pair.selected == true) {
                selected.add(pair.id);
            }

            recur(next, pair.selected);
        }
    }

    public static void printTrace(List<Pair>[] trace) {
        System.out.println("trace : =================");
        for (int i = 1; i < trace.length; i++) {
            System.out.println(i + " : " + trace[i]);
        }
    }

    public static void dfs(int cur) {

        int childCount = 0;
        int v1 = a[cur]; // cur를 선택하기로 했을 때
        int v2 = 0; // cur를 선택하지 않기로 했을 때

        if (trace0[cur] == null) {
            trace0[cur] = new ArrayList<Pair>();
        }
        if (trace1[cur] == null) {
            trace1[cur] = new ArrayList<Pair>();
        }
        
        for (int next : edges[cur]) {
            if (visited[next] == true) continue;
            visited[next] = true;
            childCount++;
            
            dfs(next);
            // dp[next][0], dp[next][1]

            v1 += dp[next][0];
            trace1[cur].add(new Pair(next, false));

            if (dp[next][0] < dp[next][1]) {
                v2 += dp[next][1];
                trace0[cur].add(new Pair(next, true));
            } else {
                v2 += dp[next][0];
                trace0[cur].add(new Pair(next, false));
            }
        }

        if (childCount == 0) { // 리프 노드
            dp[cur][0] = 0;
            dp[cur][1] = a[cur];
        } else {
            dp[cur][1] += v1;
            dp[cur][0] += v2;
        }

    }
}