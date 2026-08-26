import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1 3 1 3
        
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int i : map.keySet()) {
            int complement = k - i;
            if (map.containsKey(complement)) {
                if (set.contains(complement)) continue; // 중복계산 방지
                set.add(i);
                if (i != complement) {
                    cnt += map.get(i) * map.get(complement);
                } else { // i == complement
                    cnt = cnt + (map.get(i) * (map.get(i) - 1) / 2);
                }
            }
        }
        System.out.print(cnt);
    }
}