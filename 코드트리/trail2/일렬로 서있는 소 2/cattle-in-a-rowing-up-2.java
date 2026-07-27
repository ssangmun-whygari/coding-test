import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (cows[i] <= cows[j] && cows[j] <= cows[k]) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}