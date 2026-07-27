import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(), M = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < M; i++) B[i] = sc.nextInt();
        
        int cnt = 0;
        // A에서 길이가 M인 연속 부불 수열을 검사
        for (int i = 0; i <= N - M; i++) {
            if (isBeautiful(A, i, i + M - 1, B)) cnt++;
        }

        // isBeautiful(A, 0, 2, B);
        System.out.println(cnt);
    }

    public static boolean isBeautiful(int[] A, int i, int j, int[] B) {
        boolean[] isFound = new boolean[B.length]; // 찾을때마다 B의 대응되는 자리에 true로 체크

        for (int k = i; k <= j; k++) {
            // A[k]가 B에 있는 지 체크, 모든 k에 대하여 통과해야 함
            for (int l = 0; l < B.length; l++) {
                if (A[k] == B[l] && isFound[l] == false) {
                    isFound[l] = true;
                    break;
                }
            }
        }

        boolean allFound = true;
        for (int l = 0; l < B.length; l++) {
            if (isFound[l] == false) allFound = false;
        }
        // if (allFound) System.out.println("i : " + i + ", j : " + j);

        return allFound;
    }
}