import java.util.Scanner;
public class Main {
    public static int[][] num;
    public static int[][] moveDir;
    public static int[] dx = new int[] {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[] {0, 0, 1, 1, 1, 0, -1, -1, -1};
    public static int n;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                moveDir[i][j] = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        bt(r, c, 0);
        System.out.println(ans);
    }

    public static void bt(int r, int c, int level) {
        int curVal = num[r][c];
        int curDir = moveDir[r][c];

        boolean canProceed = false;
        do {
            int nextR = r + dx[curDir];
            int nextC = c + dy[curDir];
            if (!inRange(nextR, nextC)) break;
            if (num[nextR][nextC] >= curVal) {
                canProceed = true;
                bt(nextR, nextC, level + 1);
            }
            r = nextR; c = nextC;
        } while (true);

        if (!canProceed) {
            ans = Math.max(ans, level);
            return;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}