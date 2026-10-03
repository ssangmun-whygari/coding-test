import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            coins[i] = sc.nextInt(); // 내림차순
        }
        
        int cnt = 0;
        for (int coin : coins) {
            cnt += (k / coin);
            k = k % coin;
        }

        System.out.print(cnt);
    }
}