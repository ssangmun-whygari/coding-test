import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] A = new int[2000000 + 1];
        int[] B = new int[2000000 + 1];
        Arrays.fill(A, Integer.MAX_VALUE);
        Arrays.fill(B, Integer.MAX_VALUE);

        int coordA = 0;
        int tA = 0;
        for (int i = 0; i < n; i++) {
            int dt = sc.nextInt();
            char d = sc.next().charAt(0);
            if (d == 'R') {
                while (dt-- > 0) {
                    A[++tA] = ++coordA;
                }
            } else {
                while (dt-- > 0) {
                    A[++tA] = --coordA;
                }
            }
        }
        
        int coordB = 0;
        int tB = 0;
        for (int i = 0; i < m; i++) {
            int dt = sc.nextInt();
            char d = sc.next().charAt(0);
            if (d == 'R') {
                while (dt-- > 0) {
                    B[++tB] = ++coordB;
                }
            } else {
                while (dt-- > 0) {
                    B[++tB] = --coordB;
                }
            }
        }

        int t = Math.max(tA, tB);
        // System.out.println("t = " + t);
        if (tA < t) {
            for (int i = tA; i <= t; i++) {
                A[i] = A[tA];
            }
        } else {
            for (int i = tB; i <= t; i++) {
                B[i] = B[tB];
            }
        }

        int cnt = 0;
        for (int i = 1; i <= t; i++) {
            // System.out.println("A, i = " + i + ", A[i] = " + A[i]);
            // System.out.println("B, i = " + i + ", B[i] = " + B[i]);
            if (A[i] == B[i] && A[i - 1] != B[i - 1]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}