import java.util.*;

public class Main {
    public static int[] mapper = new int[128];
    public static int[] dx = new int[] {1, 0, -1, 0}; // 동, 북, 서, 남
    public static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        mapper['E'] = 0;
        mapper['S'] = 1;
        mapper['W'] = 2;
        mapper['N'] = 3;

        int curX = 0, curY = 0;
        int elapsed = 0;
        int answer = -1;
        for (int i = 0; i < N; i++) {
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int dirNum = mapper[dir];

            while (dist-- > 0) {
                elapsed++;

                curX = curX + dx[dirNum];
                curY = curY + dy[dirNum];

                if (curX == 0 && curY == 0) {
                    answer = elapsed;
                    break;
                }
            }
            if (answer != -1) break;
        }

        System.out.println(answer);
    }
}