import java.util.*;

public class Main {
    public static int ans = 0;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        recur(0);
        System.out.println(ans);
    }

    public static void recur(int accum) {
        if (accum == N) {
            ans += 1;
            return;
        } else if (accum > N) {
            return;
        }

        for (int i = 1; i <= 4; i++) {
            recur(i + accum);
        }
    }
}