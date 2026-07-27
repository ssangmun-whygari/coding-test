import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N  = sc.nextInt();
        int[][] plays = new int[K][N];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                plays[i][j] = sc.nextInt();
            }
        }

        // for (int i = 0; i < K; i++) {
        //     System.out.println(Arrays.toString(plays[i]));
        // }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                boolean dominant = true;
                for (int k = 0; k < K; k++) { // k번째 경기
                    // 개발자의 인덱스(순위) 찾기
                    int n1 = -1, n2 = -1;
                    for (int l = 0; l < N; l++) {
                        if (i == plays[k][l]) n1 = l;
                        if (j == plays[k][l]) n2 = l;
                    }
                    if (n1 > n2) {
                        // i가 j보다 순위가 떨어짐
                        dominant = false;
                    }
                }
                if (dominant) {
                    // System.out.println(i + " " + j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}