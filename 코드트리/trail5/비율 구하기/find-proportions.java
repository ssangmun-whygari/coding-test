import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Map<String, Integer> map = new TreeMap<>();
        int total = arr.length;
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            float proportion = (float) entry.getValue() / total * 100;
            System.out.printf("%s %.4f\n", entry.getKey(), proportion);
        }
    }
}