import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cur_row = sc.nextInt() - 1;
        int cur_col = sc.nextInt() - 1;
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(grid[cur_row][cur_col]);
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        while (true) {
            int cur_num = grid[cur_row][cur_col];
            int next_row = -1, next_col = -1;
            boolean found = false;
            for (int d = 0; d < 4; d++) {
                next_row = dx[d] + cur_row;
                next_col = dy[d] + cur_col;
                if (inRange(next_row, next_col) && cur_num < grid[next_row][next_col]) {
                    cur_num = grid[next_row][next_col];
                    cur_row = next_row;
                    cur_col = next_col;
                    found = true;
                    list.add(cur_num);
                    break;
                }
            }

            if (found == false) {
                break;
            } 
        }

        for (int val : list) {
            System.out.print(val + " ");
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}