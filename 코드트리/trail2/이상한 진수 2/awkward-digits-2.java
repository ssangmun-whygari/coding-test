import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] digits = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }

        int max = 0;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 1 - digits[i];
            // System.out.println(Arrays.toString(digits));
            max = Math.max(getDecimal(digits), max);
            digits[i] = 1 - digits[i];
        }

        System.out.println(max);
    }

    public static int getDecimal(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 2 + digits[i];
        }
        return sum;
    }
}