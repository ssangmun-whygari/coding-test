import java.util.*;
public class Main {
    public static int ans = 0;
    public static List<Integer>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        adjList = new ArrayList[N]; // 0 ~ N - 1
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            adjList[x].add(y);
            adjList[y].add(x);
        }

        boolean[] visited = new boolean[N];
        visited[0] = true;
        dfs(0, visited);

        System.out.println(ans);
    }

    public static void dfs(int cur, boolean[] visited) {
        for (int next : adjList[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            ans++;
            dfs(next, visited);
        }
    }
}