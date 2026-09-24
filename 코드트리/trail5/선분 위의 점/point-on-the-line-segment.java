import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            int num = count(a, b, points);
            sb.append(num);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static int count(int a, int b, int[] points) {
        // a 이상이 나타나는 최초 위치
        int a0 = lb(a, points);
        // b 이하가 나타나는 최대 위치
        int b0 = cb(b, points);

        if (a0 == n || b0 == -1) {
            return 0;
        } else {
            return b0 - a0 + 1;
        }
    }

    public static int lb(int x, int[] arr) {
        int left = 0;
        int right = n - 1;
        int minIdx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    public static int cb(int x, int[] arr) {
        int left = 0;
        int right = n - 1;
        int maxIdx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= x) {
                left = mid + 1;
                maxIdx = Math.max(maxIdx, mid);
            } else {
                right = mid - 1;
            }
        }
        return maxIdx;
    }
}