import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), S = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int arrSum = Arrays.stream(arr).sum();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int T = arrSum - arr[i] - arr[j];
                ans = Math.min(ans, Math.abs(T - S));
            }
        }
        System.out.println(ans);
    }
}