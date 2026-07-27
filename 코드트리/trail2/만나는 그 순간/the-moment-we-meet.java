import java.util.*;

public class Main {
    public static void main(String[] args) {
        // A, B가 몇 초에 어디있는 지를 기록한다.

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[1000 * 1000 + 1]; // 1초 후 ~ 1000초 후까지
        int[] B = new int[1000 * 1000 + 1];

        char dir = '0';
        int dt = 0;
        int t = 0;
        int coord = 0;

        for (int i = 0; i < N; i++) {
            dir = sc.next().charAt(0);
            dt = sc.nextInt();
            if (dir == 'R') {
                while (--dt >= 0) {
                    A[++t] = ++coord;
                }
            } else if (dir == 'L') {
                while (--dt >= 0) {
                    A[++t] = --coord;
                }
            }
        }

        dir = '0';
        dt = 0;
        t = 0;
        coord = 0;
        for (int i = 0; i < M; i++) {
            dir = sc.next().charAt(0);
            dt = sc.nextInt();
            if (dir == 'R') {
                while (--dt >= 0) {
                    B[++t] = ++coord;
                }
            } else if (dir == 'L') {
                while (--dt >= 0) {
                    B[++t] = --coord;
                }
            }
        }

        int firstMet = -1;
        for (int i = 2; i <= t; i++) {
            if (A[i] == B[i]) {
                firstMet = i;
                break;
            }
        }
        System.out.println(firstMet);
    }
}