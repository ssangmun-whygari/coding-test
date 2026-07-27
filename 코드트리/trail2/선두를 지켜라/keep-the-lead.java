import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] A = new int[1000 * 1000 + 1]; // `1초 후 위치 ~
        int[] B = new int[1000 * 1000 + 1];

        // 한 줄씩 처리
        int At = 0;
        for (int i = 1; i <= N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            while (t-- > 0) {
                At++;
                A[At] = A[At - 1] + v;
            }
        }

        int Bt = 0;
        for (int i = 1; i <= M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            while (t-- > 0) {
                Bt++;
                B[Bt] = B[Bt - 1] + v;
            }
        }

        int[] C = new int[1000 * 1000 + 1];
        int changed = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - B[i] > 0) {
                C[i] = 1; // 현재 선두는 A이다.
            } else if (A[i] - B[i] < 0) {
                C[i] = 2; // 현재 선두는 B이다.
            } else {
                C[i] = C[i - 1]; // 전의 선두 기록을 유지한다.
            }

            if (C[i] == 1 && C[i - 1] == 2) {
                // 현재 선두가 A이고 전에 표시한 선두가 B일때 역전이 일어난다.
                changed++;
            } else if (C[i] == 2 && C[i - 1] == 1) {
                changed++;
            }
        }

        // System.out.println("A : " + Arrays.toString(A));
        // System.out.println("B : " + Arrays.toString(B));
        System.out.println(changed);
    }
}