import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        int maxCnt = 0;
        for (int i = 0; i < N; i++) {
            // 할인할 학생 P[i]
            int[] sorted = new int[N];
            for (int j = 0; j < N; j++) {
                sorted[j] = P[j];
            }
            sorted[i] /= 2;
            Arrays.sort(sorted);
            // System.out.println("sorted : " + Arrays.toString(sorted));

            int cost = 0;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (cost + sorted[j] <= B) {
                    cost += sorted[j];
                    cnt++;
                } else {
                    break;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }
}