import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n + 1];
        int[] B = new int[m + 1]; // 부분수열
        for (int i = 1; i <= n; i++) A[i] = sc.nextInt();
        for (int i = 1; i <= m; i++) B[i] = sc.nextInt();

        int[] L_idx = new int[m + 1];
        L_idx[0] = -1;
        Arrays.fill(L_idx, 1, m + 1, n + 1);
        int j = 1; // 원본수열의 인덱스
        for (int i = 1; i <= m; i++) { // 부분수열의 인덱스
            while (j <= n && A[j] != B[i]) { // B[i] 찾기
                j++;
            }

            if (j > n) { // 끝까지 못찾음
                break;
            }

            L_idx[i] = j;
        }

        // System.out.println("L_idx : " + Arrays.toString(L_idx));


        int[] R_idx = new int[m + 1];
        R_idx[0] = -1;
        Arrays.fill(R_idx, 1, m + 1, n + 1);

        j = n;
        for (int i = m; i >= 1; i--) {
            while (j >= 1 && A[j] != B[i]) {
                j--;
            }

            if (j <= 0) {
                break;
            }

            R_idx[i] = j;
        }

        // System.out.println("R_idx : " + Arrays.toString(R_idx));

        int cnt = 0;
        for (int i = 1; i <= m; i++) { // i = 제외할 인덱스
            if (i == m) {
                if (L_idx[i - 1] <= n) {
                    cnt += 1;
                }
            } else {
                // L[i - 1], R[i + 1]
                if (R_idx[i + 1] <= n && L_idx[i - 1] <= n && L_idx[i - 1] < R_idx[i + 1]) {
                    cnt += 1;
                }
            }
        }
        System.out.print(cnt);
    }
}