import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 1000 * 1000 = 100만
        // 대략 100만 정도까지 숫자를 나타낼 수 있다.
        int[] digits = new int[20]; 
        int cnt = 0;

        while (N > 1) {
            digits[cnt++] = N % 2;
            N /= 2;
        }
        digits[cnt++] = N % 2;

        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
    }
}