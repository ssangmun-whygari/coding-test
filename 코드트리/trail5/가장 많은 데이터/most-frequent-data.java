import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        
        Map<String, Integer> strCnt = new HashMap<>();
        for (String str : arr) {
            strCnt.put(str, strCnt.getOrDefault(str, 0) + 1);
        }

        int ans = 0;
        for (String key : strCnt.keySet()) {
            if (strCnt.get(key) > ans)
                ans = strCnt.get(key);
        }
        System.out.print(ans);
    }
}