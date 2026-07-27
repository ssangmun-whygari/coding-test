import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) { // 두 배할 원소를 고름
            for (int j = 0; j < N; j++) { // 제외할 원소를 고름
                int[] arr2 = new int[N - 1];

                int idx = 0;
                for (int k = 0; k < N; k++) {
                    if (k == j) continue;
                    if (k == i) {
                        arr2[idx++] = arr[k] * 2;
                    } else {
                        arr2[idx++] = arr[k];
                    }
                }

                int sum = 0;
                for (int k = 0; k < arr2.length - 1; k++) {
                    sum += Math.abs(arr2[k] - arr2[k+1]);
                }

                ans = Math.min(ans, sum);
            }
        }

        System.out.println(ans);
    }
}