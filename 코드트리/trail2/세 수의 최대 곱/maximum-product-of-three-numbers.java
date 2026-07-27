import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);

        // + + + => + 
        // + + - =? -
        // + - - => +
        // - - - => -

        int max = Integer.MIN_VALUE;

        // +가 하나도 없으면 +를 못만든다
        // 따라서 0에 가까운 -값을 골라야 한다.
        if (sorted[n - 1] == 0) {
            max = 0;
        } else if (sorted[n - 1] < 0) {
            max = sorted[n - 1] * sorted[n - 2] * sorted[n - 3];
        } else if (sorted[n - 1] > 0) {
            // +가 하나라도 있으면
            max = Math.max(max, sorted[n - 1] * sorted[n - 2] * sorted[n - 3]);
            max = Math.max(max, sorted[n - 1] * sorted[0] * sorted[1]);
        }
        System.out.println(max);
    }
}