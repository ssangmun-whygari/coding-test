import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String binary = sc.next();

        int decimal = 0;
        for (char c : binary.toCharArray()) {
            // 주의!! : Integer.valueOf(char c)로 하면 아스키코드 값이 나옴
            // System.out.println(Integer.valueOf(c));
            // System.out.println(Character.getNumericValue(c));
            decimal = (decimal * 2) + Character.getNumericValue(c);
        }

        System.out.println(decimal);
    }
}