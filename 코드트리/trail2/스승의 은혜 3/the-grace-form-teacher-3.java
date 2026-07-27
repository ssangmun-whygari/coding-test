import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), B = sc.nextInt();
        int[] P = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            S[i] = sc.nextInt();
        }

        int maxCnt = 0;
        for (int i = 0; i < N; i++) { // 할인할 선물을 고름
            int[] cost = new int[N];
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    cost[j] = (P[j] / 2) + S[j];
                } else {
                    cost[j] = P[j] + S[j];
                }
            }
            Arrays.sort(cost);

            int cnt = 0;
            int sumCost = 0;
            for (int j = 0; j < N; j++) {
                if (sumCost + cost[j] <= B) {
                    sumCost += cost[j];
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