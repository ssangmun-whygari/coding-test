import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if (n == 1 || n == 3) {
            System.out.print(-1);
            System.exit(0);
        }

        int ans = 0;
        if ((n % 5 % 2) == 0) {
            ans += n / 5;
            n = n % 5;
            ans += (n / 2);
        } else {
            ans += (n / 5) - 1;
            n = (n % 5) + 5;
            ans += (n / 2);
        }

        System.out.print(ans);
    }
}