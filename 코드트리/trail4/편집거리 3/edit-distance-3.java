import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        int aLen = a.length();
        int bLen = b.length();
        a = " " + a;
        b = " " + b;

        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < bLen; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }

        System.out.print(dp[aLen][bLen]);
    }
}