import java.util.*;

class Cell {
    public int prevX = -1, prevY = -1;
    public char value = '\u0000';
    public int length = 0;

    @Override
    public String toString() {
        return "Cell[x:" + prevX + ",y:" + prevY + ",len:" + length + ",val:'" + value + "']";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = " " + sc.next();
        String b = " " + sc.next();
        
        Cell[][] dp = new Cell[a.length()][b.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new Cell();
            }
        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    Cell cell = dp[i][j];
                    cell.prevX = i - 1;
                    cell.prevY = j - 1;
                    cell.value = a.charAt(i);
                    cell.length = dp[i - 1][j - 1].length + 1;
                } else {
                    Cell p1 = dp[i - 1][j];
                    Cell p2 = dp[i][j - 1];
                    Cell cell = dp[i][j];
                    if (p1.length >= p2.length) {
                        // p1에서 온다.
                        cell.prevX = i - 1;
                        cell.prevY = j;
                        cell.value = '\u0000';
                        cell.length = p1.length;
                    } else {
                        // p2에서 온다.
                        cell.prevX = i;
                        cell.prevY = j - 1;
                        cell.value = '\u0000';
                        cell.length = p2.length;
                    }
                }
            }
        }

        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        StringBuilder sb = new StringBuilder();
        Cell cur = dp[a.length() - 1][b.length() - 1];
        while (cur.prevX != -1 && cur.prevY != -1) {
            if (cur.value != '\u0000') {
                sb.append(cur.value);
            }
            cur = dp[cur.prevX][cur.prevY];
        }
        System.out.print(sb.reverse());
    }
}