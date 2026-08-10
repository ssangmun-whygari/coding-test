import java.util.*;

class Pos {
    public int x, y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[] installed;
    public static int n;
    public static boolean[][] grid;
    public static List<Pos> bombs;
    public static int[][] bombRangeX;
    public static int[][] bombRangeY;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bombs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int bomb = sc.nextInt();
                if (bomb == 1) {
                    bombs.add(new Pos(i, j));
                }
            }
        }
        
        installed = new int[bombs.size()];
        grid = new boolean[n][n];

        bombRangeX = new int[3][5];
        bombRangeY = new int[3][5];
        bombRangeX[0] = new int[] {-2, -1, 0, 1, 2};
        bombRangeY[0] = new int[] {0, 0, 0, 0, 0};
        bombRangeX[1] = new int[] {-1, 0, 1, 0, 0};
        bombRangeY[1] = new int[] {0, 0, 0, -1, 1};
        bombRangeX[2] = new int[] {-1, -1, 0, 1, 1};
        bombRangeY[2] = new int[] {-1, 1, 0, -1, 1};

        recur(0);

        System.out.println(ans);
    }

    public static void recur(int num) {
        if (num >= bombs.size()) {
            ans = Math.max(count(), ans);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            installed[num] = i;
            recur(num + 1);
            installed[num] = 0;
        }
    }

    public static int count() {
        // bombs, installed, bombRangeX, bombRangeY
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = false;
        
        for (int i = 0; i < bombs.size(); i++) {
            int x = bombs.get(i).x;
            int y = bombs.get(i).y;
            int bomb = installed[i] - 1;
            for (int d = 0; d < 5; d++) {
                int nx = x + bombRangeX[bomb][d];
                int ny = y + bombRangeY[bomb][d];
                if (inRange(nx, ny)) {
                    grid[nx][ny] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j]) count++;

        return count;
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}