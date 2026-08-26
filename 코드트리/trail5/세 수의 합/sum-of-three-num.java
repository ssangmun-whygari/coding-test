import java.util.*;
public class Main {
    public static int K;
    public static int[] arr;
    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            ans += count(arr[i], i + 1, arr.length);
        }
        System.out.print(ans);
    }

    public static int count(int k, int start, int end) {
        int sum = K - k; // 합쳐서 sum이 되는 경우를 찾는다.
        int cnt = 0;
        map.clear();
        // Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            int diff = sum - arr[i];
            if (map.containsKey(diff)) {
                cnt += map.get(diff);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return cnt;
    }
}