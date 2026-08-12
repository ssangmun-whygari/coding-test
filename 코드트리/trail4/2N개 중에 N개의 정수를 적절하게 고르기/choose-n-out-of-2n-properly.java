import java.util.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int sum2N;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[2*N];
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = sc.nextInt();
            sum2N += arr[i];
        }

        List<Integer> selected = new ArrayList<>();
        recur(selected, -1);

        System.out.println(ans);
    }

    public static void recur(List<Integer> selected, int i) {
        if (selected.size() == N) {
            int sum1 = 0;
            for (int sel : selected) {
                sum1 += arr[sel];
            }
            int sum2 = sum2N - sum1;
            ans = Math.min(ans, Math.abs(sum1 - sum2));
            return;
        }

        if (i + 1 >= arr.length) { // 더 이상 고를 수 없음
            return;
        }

        // i + 1번째 숫자를 골랐을 떄
        selected.add(i + 1);
        recur(selected, i + 1);
        selected.remove(selected.size() - 1);

        // i + 1번째 숫자를 안골랐을 때
        recur(selected, i + 1);
    }
}