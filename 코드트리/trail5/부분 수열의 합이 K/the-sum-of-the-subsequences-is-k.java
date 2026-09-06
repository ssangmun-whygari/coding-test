import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefixSum[i] = arr[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // System.out.println(getSum(i, j, arr, prefixSum));
                if (k == getSum(i, j, arr, prefixSum)) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    public static int getSum(int s, int e, int[] arr, int[] prefixSum) {
        return prefixSum[e] - prefixSum[s] + arr[s];
    }
}