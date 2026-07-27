import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt(), Y = sc.nextInt();
        int ans = 0;
        for (int i = X; i <= Y; i++) {
            if (check(i)) ans++;
        }
        System.out.println(ans);
    }

    public static boolean check(int t) {
        String str = t + "";
        boolean isValid = false;
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (i == j) continue;
                char y = str.charAt(j);
                if (x == y) cnt++;
            }
            if (cnt == str.length() - 2) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}