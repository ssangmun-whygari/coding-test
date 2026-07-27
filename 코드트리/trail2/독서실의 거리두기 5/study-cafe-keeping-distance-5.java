import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        String str = sc.next();
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i) - '0';
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) continue;

            arr[i] = 1; // 인원을 배치한다

            // 가장 가까운 두 사람 간의 거리를 측정한다
            int prevIdx = -1;
            int dist = 0;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (arr[j] == 1) {
                    if (prevIdx != -1) {
                        dist = j - prevIdx;
                        minDist = Math.min(minDist, dist);
                    }
                    prevIdx = j;
                }
            }

            ans = Math.max(ans, minDist);
            arr[i] = 0;
        }

        System.out.println(ans);
    }
}