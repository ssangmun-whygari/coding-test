import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        
        // L[x] : 왼쪽에서 x번째까지 봤을 때 그동안 C가 등장한 횟수
        int[] L = new int[n];
        if (str.charAt(0) == 'C') L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] + (str.charAt(i) == 'C' ? 1 : 0);
        }

        // R[x] : 오른쪽에서 x번째까지 봤을 때 그동안 W가 등장한 횟수
        int[] R = new int[n];
        if (str.charAt(n - 1) == 'W') R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] + (str.charAt(i) == 'W' ? 1 : 0);
        }

        // System.out.println("L : " + Arrays.toString(L));
        // System.out.println("R : " + Arrays.toString(R));

        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (str.charAt(i) == 'O') {
                ans += L[i - 1] * R[i + 1];
            }
        }
        System.out.print(ans);
    }
}