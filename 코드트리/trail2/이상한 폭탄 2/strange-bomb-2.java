import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 어떤 위치에 있는 폭탄의 특정 거리 안을 탐색한다. : K
        // 모든 위치에 대해 탐색한다 : N

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] bombs = new int[N];
        for (int i = 0; i < N; i++) {
            bombs[i] = sc.nextInt();
        }

        int maxNum = -1;
        for (int i = 0; i < N; i++) {
            int num = bombs[i];
            for (int j = i - K; j <= i + K; j++) {
                if (j < 0 || j >= N || j == i) continue;
                if (num == bombs[j]) {
                    maxNum = Math.max(num, maxNum);
                }
            }
        }
        System.out.println(maxNum);
    }
}