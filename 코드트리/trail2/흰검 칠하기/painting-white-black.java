import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x1 = new int[N];
        int[] x2 = new int[N];
        char[] dirs = new char[N];
        int now = 0;
        int OFFSET = 100 * 1000;

        for (int i = 0; i < N; i++) {
            int dist = sc.nextInt();
            char dir = sc.next().charAt(0);
            if (dir == 'R') {
                // now ~ now + dist 구간 색칠
                x1[i] = now;
                x2[i] = now + dist - 1;
                now = now + dist - 1;
                dirs[i] = dir;
            } else if (dir == 'L') {
                // 예 : now = 0, dist = 5이라면 -4 ~ 0을 칠해야 함
                x1[i] = now - dist + 1;
                x2[i] = now;
                now = now - dist + 1;
                dirs[i] = dir;
            }
            x1[i] += OFFSET;
            x2[i] += OFFSET;
        }

        // System.out.println("x1 : " + Arrays.toString(x1));
        // System.out.println("x2 : " + Arrays.toString(x2));
        // System.out.println("dirs : " + Arrays.toString(dirs));

        int[] blacks = new int[100 * 1000 * 2];
        int[] whites = new int[100 * 1000 * 2];
        char[] last = new char[100 * 1000 * 2];
        for (int i = 0; i < N; i++) {
            if (dirs[i] == 'R') { // 검은색으로 칠함
                for (int j = x1[i]; j <= x2[i]; j++) {
                    blacks[j] += 1;
                    last[j] = 'B'; // 마지막으로 칠한 색이 검정색
                }
            } else { // 흰색으로 칠함
                for (int j = x1[i]; j <= x2[i]; j++) {
                    whites[j] += 1;
                    last[j] = 'W'; // 마지막으로 칠한 색이 흰색
                }
            }
        }

        int b = 0;
        int w = 0;
        int g = 0;
        for (int i = 0; i < blacks.length; i++) {
            if (blacks[i] >= 2 && whites[i] >= 2) {
                g++;
            } else if (last[i] == 'B') {
                b++;
            } else if (last[i] == 'W') {
                w++;
            }
        }

        System.out.println(w + " " + b + " " + g);
    }
}