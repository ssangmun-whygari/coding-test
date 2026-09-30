import java.util.*;

public class Main {
    public static int MAX_RIGHT = (int) 1e9;
    // public static int MAX_RIGHT = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }

        Arrays.sort(pos);

        int left = 0;
        int right = MAX_RIGHT;
        int ans = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (is_possible(mid, k, pos)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(ans);
    }

    public static boolean is_possible(int r, int k, int[] pos) {
        // 사정거리 반경이 r인 폭탄으로 K번 이하에 점들을 모두 제거하는 게 가능한가?
        int idx = 0;
        int lastIdx = 0;
        int cnt = 0;
        while (idx < pos.length) {
            while (idx < pos.length && pos[idx] <= pos[lastIdx] + 2 * r) {
                idx++;
            }
            lastIdx = idx;
            cnt++;
        }

        return cnt <= k;
    }
}