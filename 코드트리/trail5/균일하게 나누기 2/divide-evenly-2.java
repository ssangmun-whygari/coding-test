import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y); // x가 같다면 y순으로 정렬됨
        }
    }
}

public class Main {
    public static int MAX_N = 501; // 501
    public static int n;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        // 0, 2, ... 1000, grid[a][b]는 경계선 x = 2a, y = 2b에 해당
        // 3사분면에 있는 점의 개수를 구함
        grid = new int[MAX_N][MAX_N];

        TreeSet<Point> xSet = new TreeSet<>(); // x순으로 정렬된 treeSet
        TreeSet<Point> ySet = new TreeSet<>();
        

        for (int i = 0; i < n; i++) {
            xSet.add(new Point(x[i], y[i]));
        }

        // 0, 2, 4, ... 1000
        for (int i = 0; i < MAX_N; i++) {
            // x = 2 * i 이하인 점을 제거한다
            while (!xSet.isEmpty() && xSet.first().x <= 2 * i) {
                Point p = xSet.first();
                xSet.remove(xSet.first());
                ySet.add(p);
            }

            for (int j = 0; j < MAX_N; j++) {
                // y = 2 * i 이하인 점을 제거한다.
                int num = 0;
                while (!ySet.isEmpty() && ySet.first().y <= 2 * j) {
                    ySet.remove(ySet.first());
                    num++;
                }

                // 누적합을 그 자리에서 계산
                if (i == 0 && j == 0) {
                    grid[i][j] = num;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + num;
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + num;
                } else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j] - grid[i - 1][j - 1] + num;
                }
            }
        }

        // System.out.println(printGrid(grid));

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                ans = Math.min(ans, getMaxAreaCnt(i, j, grid));
            }
        }
        System.out.print(ans);
    }

    public static int getMaxAreaCnt(int i, int j, int[][] grid) {
        // grid[i][MAX_N - 1] : 2사분면 + 3사분면, grid[MAX_N - 1][j] : 3사분면 + 4사분면
        int q3 = grid[i][j];
        int q2 = grid[i][MAX_N - 1] - grid[i][j];
        int q4 = grid[MAX_N - 1][j] - grid[i][j];
        int q1 = n - q2 - q3 - q4;

        return Math.max(Math.max(q1, q2), Math.max(q3, q4));
    }

    public static String printGrid(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("grid : \n");
        System.out.println("grid : ");
        for (int i = 0; i < grid.length; i++) {
            sb.append(Arrays.toString(grid[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
}