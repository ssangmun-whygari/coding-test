import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            
            int num = ub(x, arr) - lb(x, arr);
            sb.append(num);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    // target보다 같거나 큰 숫자가 나오는 최초의 위치
    public static int lb(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;
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

    // target보다 큰 숫자가 나오는 최초의 위치
    public static int ub(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }
        return minIdx;
    }
}