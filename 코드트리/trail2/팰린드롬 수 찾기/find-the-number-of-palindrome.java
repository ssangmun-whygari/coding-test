import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int cnt = 0;
        for (int i = x; i <= y; i++) {
            if (isPalindrome(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isPalindrome(int x) {
        String str = x + "";
        boolean result = true;
        for (int i = 0; i < str.length() / 2; i++) {
            char l = str.charAt(i);
            char r = str.charAt(str.length() - 1 - i);
            if (l != r) {
                result = false;
                break;
            }
        }
        return result;
    }
}