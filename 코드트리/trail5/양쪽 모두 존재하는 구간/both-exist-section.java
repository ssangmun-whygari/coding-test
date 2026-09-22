import java.util.*;
public class Main {
    public static int[] arr;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Map<Integer, Integer> map_outer = new HashMap<>();
        int dn_outer = 0;
        for (int i = 0; i < n; i++) {
            map_outer.put(arr[i], map_outer.getOrDefault(arr[i], 0) + 1);
        }
        dn_outer = map_outer.keySet().size();

        Map<Integer, Integer> map_inner = new HashMap<>();
        int dn_inner = 0;

        int j = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            while (canMove(j + 1, dn_inner)) {
                if (map_inner.getOrDefault(arr[j + 1], 0) == 0) {
                    dn_inner += 1;
                }
                map_inner.put(arr[j + 1], map_inner.getOrDefault(arr[j + 1], 0) + 1);

                if (map_outer.getOrDefault(arr[j + 1], 0) == 1) {
                    dn_outer -= 1;
                }
                map_outer.put(arr[j + 1], map_outer.getOrDefault(arr[j + 1], 0) - 1);

                j++;
            }

            if (dn_inner == m && dn_outer == m) {
                minLen = Math.min(j - i + 1, minLen);
            }

            if (map_inner.get(arr[i]) == 1) {
                dn_inner -= 1;
            }
            map_inner.put(arr[i], map_inner.get(arr[i]) - 1);
            if (map_outer.get(arr[i]) == 0) {
                dn_outer += 1;
            }
            map_outer.put(arr[i], map_outer.get(arr[i]) + 1);
        }

        System.out.print(minLen == Integer.MAX_VALUE ? -1 : minLen);
    }

    public static boolean canMove(int idx, int dn_inner) {
        if (idx == n) return false;
        if (dn_inner == m) return false;
        return true;
    }
}