import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int idx = b_search(x, arr);
            sb.append((idx != -1) ? idx + 1 : -1);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static int b_search(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}