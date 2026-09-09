import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            switch (ch) {
                case 'H':
                    B[i] = 0;
                    break;
                case 'S':
                    B[i] = 1;
                    break;
                case 'P':
                    B[i] = 2;
                    break;
            }
        }

        int ans = 0;
        for (int A = 0; A <= 2; A++) {
            if (n <= 1) {
                ans = 1;
                break;
            }

            int[] L = new int[n];
            L[0] = match(A, B[0]);
            for (int j = 1; j < L.length; j++) {
                L[j] = L[j - 1] + match(A, B[j]);
            }

            Set<Integer> alt = new HashSet<>(Arrays.asList(0, 1, 2));
            alt.remove(A);

            int max = 0;
            for (int hand : alt) {
              // R 배열 작성
              int[] R = new int[n];
              R[n - 1] = match(hand, B[n - 1]);
              for (int j = n - 2; j >= 0; j--) {
                  R[j] = R[j + 1] + match(hand, B[j]);
              }
              
              // j째 시합에서 낼 패를 전환한다.
              for (int j = 0; j < n; j++) {
                if (j == 0) {
                  int cand = R[j];
                  max = Math.max(cand, max);
                } else {
                  int cand = L[j - 1] + R[j];
                  max = Math.max(cand, max);
                }
              }
            }
            ans = Math.max(ans, max);
        }
        System.out.print(ans);
    }

    // a가 이겼으면 1, 아니면 0 반환
    public static int match(int a, int b) {
        if (a == 2) {
            return (b == 0) ? 1 : 0;
        } else {
            if (b - a == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}