import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // printGrid(grid);

        char c1 = (grid[0][0] == 'W' ? 'B' : 'W');
        char c2 = (c1 == 'W' ? 'B' : 'W');
        char c3 = (c2 == 'W' ? 'B' : 'W');
        
        int ans = 0;
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                // 첫번째 발판
                if (grid[i][j] != c1) continue;
                for (int k = i + 1; k < R; k++) {
                    for (int l = j + 1; l < C; l++) {
                        // 두번째 발판
                        if (grid[k][l] != c2) continue;
                        // 세번째 발판(도착지)
                        for (int m = k + 1; m < R; m++) {
                            for (int n = l + 1; n < C; n++) {
                                if (m != R - 1 || n != C - 1) continue;
                                if (grid[m][n] == c3) {
                                    // System.out.println("i : " + i + ", j : " + j + ", k : " + k + ", l : " + l);
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}