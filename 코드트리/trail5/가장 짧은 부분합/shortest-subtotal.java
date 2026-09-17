import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int j = 0;
        int sum = arr[0];
        int ans = 100_001;

        for (int i = 0; i < n; i++) {
            while (j < n - 1) {
                if (sum >= s) {
                    break;
                }
                j++;
                sum += arr[j];
            }
            
            if (sum >= s) {
                ans = Math.min(ans, j - i + 1);
            }
            
            sum -= arr[i];
        }

        System.out.print(ans == 100_001 ? -1 : ans);
    }
}