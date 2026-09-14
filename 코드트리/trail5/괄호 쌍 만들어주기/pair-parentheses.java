import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int n = A.length();
        
        int[] L = new int[n + 2];
        int lnum = 0; // 연속된 ( 괄호의 수
        for (int i = 1; i <= n; i++) {
            char ch = A.charAt(i - 1);
            if (ch == '(') {
                lnum++;
                if (i == n) L[i] = lnum;
            } else {
                L[i - 1] = lnum;
                lnum = 0;
            }
        }

        int[] R = new int[n + 2];
        int rnum = 0;
        for (int i = n; i >= 1; i--) {
            char ch = A.charAt(i - 1);
            if (ch == ')') {
                rnum++;
                if (i == 1) R[i] = rnum;
            } else {
                R[i + 1] = rnum;
                rnum = 0;
            }
        }

        long sum = 0;
        long cnt = 0;
        for (int i = n; i >= 1; i--) {
            if (R[i] > 0) {
                cnt += (R[i] - 1);
            } else if (L[i] > 0) {
                sum += (cnt * (L[i] - 1));
            }
        }

        System.out.println(sum);
    }
}