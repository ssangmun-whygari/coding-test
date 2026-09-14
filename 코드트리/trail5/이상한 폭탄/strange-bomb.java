import java.util.*;

public class Main {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            // arr[i] : 폭탄의 번호, i : 좌표
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<Integer>());
            }
            map.get(arr[i]).add(i);
        }

        int maxNo = -1;
        for (int i : map.keySet()) {
            // i : 폭탄의 번호
            List<Integer> coords = map.get(i);

            boolean exploded = false;
            for (int j = 1; j < coords.size(); j++) {
                if (coords.get(j) - coords.get(j - 1) <= k) {
                    exploded = true;
                    break;
                }
            }

            if (exploded == true) {
                maxNo = Math.max(i, maxNo);
            }
        }
        System.out.println(maxNo);
    }
}