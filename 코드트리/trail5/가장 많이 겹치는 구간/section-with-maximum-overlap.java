import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] check = new int[200_000 + 1];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            check[x1] = 1;
            check[x2] = -1;
        }

        int maxSum = 0;
        int sum = 0;
        for (int i = 1; i <= 200_000; i++) {
            sum += check[i];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);
    }
}