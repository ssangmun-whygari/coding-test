import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int avg = sum / N;

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > avg) {
                ans += (arr[i] - avg);
            }
        }

        System.out.println(ans);
    }
}