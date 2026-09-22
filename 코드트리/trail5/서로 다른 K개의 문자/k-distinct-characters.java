import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int k = sc.nextInt();

        Set<Character> set = new HashSet<>();
        int[] counting = new int[128];

        int j = -1;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n) {
                char ch = s.charAt(j + 1);
                counting[ch]++;
                set.add(ch);
                if (set.size() > k) {
                    counting[ch]--;
                    if (counting[ch] == 0) {
                        set.remove(ch);
                    }
                    break;
                }
                j++;
            }

            if (maxLen < j - i + 1) {
                maxLen = j - i + 1;
            }
            
            counting[s.charAt(i)]--;
            if (counting[s.charAt(i)] == 0) {
                set.remove(s.charAt(i));
            }
        }

        System.out.print(maxLen);
    }
}