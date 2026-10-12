import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = oneBitCount(arr[i]);
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (no_overlap(i, j, k, arr, count)) {
                        ans = Math.max(ans, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }

        System.out.print(ans);
    }

    public static boolean no_overlap(int i0, int i1, int i2, int[] arr, int[] count) {
        int x = arr[i0];
        int y = arr[i1];
        int z = arr[i2];

        // x, y 겹치는 지 비교
        if (oneBitCount(x ^ y) != count[i0] + count[i1]) {
            return false;
        }
        if (oneBitCount(x ^ z) != count[i0] + count[i2]) {
            return false;
        }
        if (oneBitCount(y ^ z) != count[i1] + count[i2]) {
            return false;
        }
        return true;
    }

    public static int oneBitCount(int x) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            // x >> i, 1
            if ( (1 & (x >> i)) == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}