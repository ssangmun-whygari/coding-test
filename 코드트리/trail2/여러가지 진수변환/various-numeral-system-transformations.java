import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal = sc.nextInt();
        int base = sc.nextInt();

        System.out.println(convert(decimal, base));
    }

    public static String convert(int decimal, int base) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (decimal < base) {
                sb.append(decimal % base);
                break;
            }

            sb.append(decimal % base);
            decimal /= base;
        }
        return sb.reverse().toString();
    }
}