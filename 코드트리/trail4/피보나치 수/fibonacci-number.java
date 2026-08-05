import java.util.*;
public class Main {
    public static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        memo = new int[45 + 1]; // 1 ~ n;
        Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 1;
        recur(n);
        System.out.println(memo[n]);
    }

    public static int recur(int n) {
        if (n <= 2) { // n = 1, 2
            return 1;
        }
        if (memo[n] == -1) {
            memo[n] = recur(n - 1) + recur(n - 2);
        }
        return memo[n];
    }
}