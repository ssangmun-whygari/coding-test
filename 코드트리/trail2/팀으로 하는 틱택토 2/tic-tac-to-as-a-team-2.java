import java.util.*;
public class Main {
    public static int[][] cases = new int[][] {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String line = sc.next();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                boolean victory = false;
                for (int[] c : cases) {
                    int iNum = 0, jNum = 0;
                    for (int idx : c) {
                        int x = (idx / 3);
                        int y = (idx % 3);
                        int member = board[x][y];
                        if (member == i) iNum++;
                        if (member == j) jNum++;
                    }
                    if (iNum > 0 && jNum > 0 && iNum + jNum == 3) {
                        victory = true;
                        break;
                    }
                }
                if (victory) ans++;
            }
        }

        System.out.println(ans);
    }
}