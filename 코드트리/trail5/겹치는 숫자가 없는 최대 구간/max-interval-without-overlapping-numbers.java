import java.util.Scanner;

public class Main {
    public static int MAX_N = 100_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] counting = new int[MAX_N + 1]; // 1 ~ MAX_N

        int ans = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            while (j + 1 <= n && counting[arr[j + 1]] == 0) {
                counting[arr[j + 1]]++;
                j++;
            }

            // System.out.println("i : " + i + ", j : " + j);

            ans = Math.max(ans, j - i + 1);

            counting[arr[i]]--;
        }

        System.out.print(ans);
    }
}