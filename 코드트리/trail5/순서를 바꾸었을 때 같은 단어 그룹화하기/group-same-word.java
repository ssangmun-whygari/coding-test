import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            String key = sort(word);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > ans) {
                ans = map.get(key);
            }
        }
        System.out.print(ans);
    }

    public static String sort(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}