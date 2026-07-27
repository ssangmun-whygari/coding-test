import java.util.*;

public class Main {
    public static int N;
    public static int T;
    public static int[] dx = new int[] {0, 1, -1, 0}; // 행
    public static int[] dy = new int[] {1, 0, 0, -1}; // 열
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = sc.nextInt();
        int R = sc.nextInt() - 1; // 0-based
        int C = sc.nextInt() - 1; // 0-based
        char D = sc.next().charAt(0);
        int currDir = getDir(D);

        while (T-- > 0) {
            int nR = R + dx[currDir];
            int nC = C + dy[currDir];
            if (inRange(nR, nC)) {
                R = nR;
                C = nC;
            } else {
                currDir = 3 - currDir;
            }
            // System.out.println("R : " + R + ", C : " + C);
        }

        R++; C++;
        System.out.println(R + " " + C);
    }

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static int getDir(char dir) {
        if (dir == 'R') {
            return 0;
        } else if (dir == 'D') {
            return 1;
        } else if (dir == 'U') {
            return 2;
        } else if (dir == 'L') {
            return 3;
        }
        return -1;
    }
}