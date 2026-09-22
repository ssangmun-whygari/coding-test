import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        
        int[] alphabets = new int[128];

        int maxLen = 0;
        int j = -1;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && alphabets[s.charAt(j + 1)] < 1) {
                alphabets[s.charAt(j + 1)]++;
                j++;
            }

            if (maxLen < j - i + 1) {
                maxLen = j - i + 1;
            }

            alphabets[s.charAt(i)]--;
        }

        System.out.print(maxLen);
    }
}