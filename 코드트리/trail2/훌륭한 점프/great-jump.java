import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 1을 최대로 밟는다, 2를 최대로 밟는다, ... 100을 최대로 밟는다

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sorted = new int[N];
        System.arraycopy(arr, 0, sorted, 0, N);
        Arrays.sort(sorted);

        int ans = sorted[N - 1];
        for (int i = 0; i < N; i++) {
            int limit = sorted[i];
            int jump = 1;
            int curPos = 0;
            if (arr[curPos] > limit) continue;

            boolean possible = true;
            while (curPos != N - 1) {
                possible = false;
                for (int j = jump; j <= K; j++) {
                    if (curPos + j >= N) break;
                    if (arr[curPos + j] <= limit) {
                        curPos = curPos + j;
                        possible = true;
                        break;
                    }
                }
                if (!possible) break;
            }

            if (possible) {
                ans = limit;
                break;
            }
        }

        System.out.println(ans);

    }
}