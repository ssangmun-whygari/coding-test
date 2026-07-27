import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] lb = new int[N];
        int[] ub = new int[N];
        for (int i = 0; i < N; i++) {
            lb[i] = sc.nextInt();
            ub[i] = sc.nextInt();
        }

        int ans = 0;
        for (int x0 = lb[0]; x0 <= ub[0]; x0++) {
            // 나머지 범위를 조사
            int x = x0;
            boolean pass = true;
            for (int i = 1; i < N; i++) {
                // lb[i], ub[i]
                x *= 2;
                if (x < lb[i] || x > ub[i]) {
                    pass = false;
                    break;
                }
            }
            if (pass && x0 % 2 == 0) {
                ans = x0 / 2;
                break;
            }
        }
        System.out.println(ans);
    }
}