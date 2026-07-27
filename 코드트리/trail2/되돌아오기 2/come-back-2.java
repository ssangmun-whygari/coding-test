import java.util.*;

public class Main {
    public static int[] dx = new int[] {0, 1, 0, -1}; // 북, 동, 남, 서
    public static int[] dy = new int[] {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int curX = 0, curY = 0;
        int dir = 0; // 초기값은 북
        int elapsed = 0;
        int ans = -1;
        for (char cmd : input.toCharArray()) {
            elapsed++;
            if (cmd == 'R') {
                dir = (dir + 1) % 4;
            } else if (cmd == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                curX += dx[dir];
                curY += dy[dir];
                if (curX == 0 && curY == 0) {
                    ans = elapsed;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}