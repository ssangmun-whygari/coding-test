import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = " " + sc.next();
        String B = " " + sc.next();
        int Alen = A.length() - 1;
        int Blen = B.length() - 1;
        
        int[][] dp = new int[A.length()][B.length()];

        for (int i = 1; i <= Alen; i++) {
            if (A.charAt(i) == B.charAt(1)) {
                dp[i][1] = 1;
            } else {
                dp[i][1] = dp[i - 1][1];
            }
        }
        for (int j = 1; j <= Blen; j++) {
            if (A.charAt(1) == B.charAt(j)) {
                dp[1][j] = 1;
            } else {
                dp[1][j] = dp[1][j - 1];
            }
        }

        for (int i = 2; i <= Alen; i++) {
            for (int j = 2; j <= Blen; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.print(dp[Alen][Blen]);
    }
}