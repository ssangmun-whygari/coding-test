import java.util.*;
public class Main {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int n;
    public static int k;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = -1;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            while (canMove(j + 1)) {
                map.put(arr[j + 1], map.getOrDefault(arr[j + 1], 0) + 1);
                j++;
            }

            if (maxLen < j - i + 1) {
                maxLen = (j - i + 1);
            }

            if (map.get(arr[i]) <= 0) {
                throw new RuntimeException("예상하지 않은 값");
            }
            map.put(arr[i], map.get(arr[i]) - 1);
        }

        System.out.print(maxLen);
    }

    public static boolean canMove(int j) {
        if (j >= n) return false;
        if (map.getOrDefault(arr[j], 0) == k) {
            // 이미 K개가 들어있어서 더 추가가 안됨
            return false;
        }
        return true;
    }
}