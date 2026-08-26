import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
        }
        
        Map<String, Integer> strToNum = new HashMap<>();
        Map<Integer, String> numToStr = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            strToNum.put(words[i], i);
            numToStr.put(i, words[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = sc.next();
            if (isAlphabet(input.charAt(0))) {
                sb.append(strToNum.get(input) + "\n");
            } else {
                Integer num = Integer.valueOf(input);
                sb.append(numToStr.get(num) + "\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean isAlphabet(char ch) {
        return ch - 'a' >= 0 && 'z' - ch >= 0;
    }
}