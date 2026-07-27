import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        System.out.println(dtob(btod(n) * 17));
    }

    public static int btod(String n) {
        int result = 0;
        for (char digit : n.toCharArray()) {
            result = (result * 2) + Character.getNumericValue(digit);
        }
        return result;
    }

    public static String dtob(int n) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (n < 2) {
                sb.append(n % 2);
                break;
            }
            sb.append(n % 2);
            n = n / 2;
        }

        return sb.reverse().toString();
    }
}