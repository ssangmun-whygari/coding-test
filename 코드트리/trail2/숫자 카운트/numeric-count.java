import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int a0 = 1; a0 <= 9; a0++) {
            for (int a1 = 1; a1 <= 9; a1++) {
                for (int a2 = 1; a2 <= 9; a2++) {
                    if (a0 == a1 || a1 == a2 || a0 == a2) continue;
                    boolean pass = true;
                    for (int i = 0; i < N; i++) {
                        int b = arr[i][0];
                        int b0 = b / 100, b1 = (b % 100) / 10, b2 = (b % 10);
                        int cnt1 = getCnt1(a0, a1, a2, b0, b1, b2);
                        int cnt2 = getCnt2(a0, a1, a2, b0, b1, b2);
                        if (cnt1 != arr[i][1] || cnt2 != arr[i][2]) {
                            pass = false;
                            break;
                        }
                    }
                    if (pass) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static int getCnt1 (int a0, int a1, int a2, int b0, int b1, int b2) {
        int cnt = 0;
        if (a0 == b0) cnt++;
        if (a1 == b1) cnt++;
        if (a2 == b2) cnt++;
        return cnt;
    }

    public static int getCnt2(int a0, int a1, int a2, int b0, int b1, int b2) {
        int cnt = 0;
        if (b0 == a1 || b0 == a2) cnt++;
        if (b1 == a0 || b1 == a2) cnt++;
        if (b2 == a0 || b2 == a1) cnt++;
        return cnt;
    }
}