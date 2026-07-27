import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        String n = sc.next();

        // b1 -> 10진수
        int decimal = 0;

        for (char c : n.toCharArray()) {
            decimal = (decimal * b1) + Character.getNumericValue(c);
        }

        // 10진수 -> b2
        int[] digits = new int[20];
        int cnt = 0;

        while (true) {
            if (decimal < b2) {
                digits[cnt++] = decimal % b2;
                break;
            }
            digits[cnt++] = decimal % b2;
            decimal /= b2;
        }

        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
    }
}