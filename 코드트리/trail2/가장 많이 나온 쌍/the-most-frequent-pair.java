import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] pairs = new int[M][2];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            pairs[i][0] = min;
            pairs[i][1] = max;
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int cnt = 0;
                for (int k = 0; k < M; k++) {
                    if (pairs[k][0] == i && pairs[k][1] == j) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }

        System.out.println(ans);
    }
}