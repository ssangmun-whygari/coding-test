import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;

        int debug = 100;
        while (debug-- > 0 && !isSequential(arr, 0, n - 1)) {
            // n - 1 자리부터 검사
            int[] arr2 = new int[n];
            int[] arr3 = new int[n];

            int maxLength = 0;
            for (int i = n - 1; i >= 0; i--) {

                // i 자리에 arr[0]이 들어간다.
                arr2[i] = arr[0];
                for (int j = 0; j <= i - 1; j++) {
                    arr2[j] = arr[j + 1];
                }
                for (int j = i + 1; j < n; j++) {
                    arr2[j] = arr[j];
                }
                // n - 1부터 세었을 때 얼마나 증가하는 수열인가?
                int length = 1;
                for (int j = n - 1; j >= 1; j--) {
                    if (arr2[j - 1] < arr2[j]) {
                        length++;
                    } else {
                        break;
                    }
                }
                // System.out.println("length : " + length + ", arr2 : " + Arrays.toString(arr2));

                if (maxLength < length) {
                    maxLength = length;
                    System.arraycopy(arr2, 0, arr3, 0, n);
                }
            }
            System.arraycopy(arr3, 0, arr, 0, n);
            // System.out.println("maxLength : " + maxLength + ", arr : " + Arrays.toString(arr));
            ans++;
        }

        System.out.println(ans);
    }
    
    public static boolean isSequential(int[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[k + 1] != arr[k] + 1) return false;
        }
        return true;
    }
}