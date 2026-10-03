import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum = sum + a[i];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);
    }
}