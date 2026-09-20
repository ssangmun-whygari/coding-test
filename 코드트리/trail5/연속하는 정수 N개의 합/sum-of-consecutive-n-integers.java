import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int j = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            while (j + 1 <= n && sum + arr[j + 1] <= m) {
                sum += arr[j + 1];
                j++;
            }

            if (sum == m) {
                cnt++;
            }

            sum -= arr[i];
        }

        System.out.print(cnt);
    }
}