import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] curPos = new int[2]; // x, y

        int[] dx = new int[] {1, 0, -1, 0}; // 동(E) -> 북(N) -> 서(W) -> 남(S)
        int[] dy = new int[] {0, 1, 0, -1};
        

        int N = sc.nextInt();
        int dirNum = 0;
        for (int i = 0; i < N; i++) {
            char dir = sc.next().charAt(0);
            int s = sc.nextInt();
            if (dir == 'E') {
                dirNum = 0;
            } else if (dir == 'N') {
                dirNum = 1;
            } else if (dir == 'W') {
                dirNum = 2;
            } else if (dir == 'S') {
                dirNum = 3;
            }
            curPos[0] += (dx[dirNum] * s);
            curPos[1] += (dy[dirNum] * s);
        }
        System.out.print(curPos[0] + " " + curPos[1]);
    }
}