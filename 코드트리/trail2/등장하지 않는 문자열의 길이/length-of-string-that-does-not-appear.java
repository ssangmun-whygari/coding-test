import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        boolean found = false;
        int ans = -1;
        for (int l = 1; l <= N; l++) {
            found = true;
            Map<String, Integer> map = new HashMap<>();
            for (int start = 0; start + l <= N; start++) {
                String substr = str.substring(start, start + l);
                // System.out.println("substr : " + substr);
                map.put(substr, map.getOrDefault(substr, 0) + 1);
                if (map.getOrDefault(substr, 0) >= 2) {
                    found = false;
                    break;
                }
            }
            if (found) {
                ans = l;
                break;
            }
        }

        System.out.println(ans);
    }
}