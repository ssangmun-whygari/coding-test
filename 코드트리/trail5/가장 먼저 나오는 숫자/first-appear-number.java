import java.util.Scanner;
public class Main {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int target : queries) {
            int idx = lb(target, arr);
            if (idx >= n || arr[idx] != target) {
                sb.append(-1);
            } else {
                sb.append(idx + 1);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    public static int lb(int target, int[] arr) {
        int left = 0;
        int right = n - 1;
        int minIdx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }
}