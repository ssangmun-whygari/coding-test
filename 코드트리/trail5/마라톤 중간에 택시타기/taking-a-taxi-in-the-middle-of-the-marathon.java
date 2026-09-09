import java.util.Scanner;
public class Main {
    public static int[] x;
    public static int[] y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = new int[n + 1];
        y = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int[] L = new int[n + 1];
        int[] R = new int[n + 1];

        for (int i = 2; i < L.length; i++) {
            L[i] = L[i - 1] + getDist(i - 1, i);
        }
        for (int i = R.length - 2; i >= 1; i--) {
            R[i] = R[i + 1] + getDist(i, i + 1);
        }

        int ans = Integer.MAX_VALUE;
        // 체크포인트 제외하기
        for (int i = 2; i <= n - 1; i++) {
            // i번째 체크포인트를 제거했을 때
            int cand = L[i - 1] + R[i + 1] + getDist(i - 1, i + 1);
            ans = Math.min(ans, cand);
        }

        System.out.print(ans);
    }

    // i번째 점과 j번째 점 사이의 맨하탄 거리
    public static int getDist(int i, int j) {
        return Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
    }
}