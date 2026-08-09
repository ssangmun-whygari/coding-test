import java.util.*;

class Cell implements Comparable<Cell> {
    public int x, y, num;

    Cell(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    public int compareTo(Cell other) {
        if (this.num != other.num) {
            return Integer.compare(this.num, other.num);
        } else if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        Cell[] cellArr = new Cell[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cellArr[j + m * i] = new Cell(i, j, grid[i][j]);
            }
        }
        Arrays.sort(cellArr);

        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = 1;

        for (int i = 0; i < cellArr.length; i++) {
            for (int j = 0; j < i; j++) {
                // cellArr[i].x, cellArr[i].y
                if (cellArr[i].x > cellArr[j].x && cellArr[i].y > cellArr[j].y) { 
                    // 갈 수 있는가?(오른쪽 아래 방향으로만 이동 가능)
                    // cellArr[i].num, cellArr[j].num
                    if (cellArr[i].num <= cellArr[j].num) continue; // 큰 숫자로만 이동가능하다
                    if (dp[cellArr[j].x][cellArr[j].y] == -1) continue; // 한번도 도달한 적 없으면 안된다
                    dp[cellArr[i].x][cellArr[i].y] = Math.max(dp[cellArr[j].x][cellArr[j].y] + 1, dp[cellArr[i].x][cellArr[i].y]);
                    // printGrid(dp);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

    public static void printGrid(int[][] grid) {
        System.out.println("grid : ");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("grid end");
    }
}