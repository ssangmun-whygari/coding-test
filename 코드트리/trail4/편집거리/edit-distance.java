import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int Alen = A.length();
        int Blen = B.length();
        A = " " + A;
        B = " " + B;

        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i <= Alen; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= Blen; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= Alen; i++) {
            for (int j = 1; j <= Blen; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }

        // for (int i = 0; i <= Alen; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.print(dp[Alen][Blen]);
    }
}