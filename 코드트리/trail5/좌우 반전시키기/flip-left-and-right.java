import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int cnt = 0;
        // System.out.println("arr : " + Arrays.toString(arr));
        for (int i = 1; i < N - 1; i++) {
            // arr[i - 1], arr[i]
            if (arr[i - 1] == 0) {
                cnt++;
                // arr[i]을 눌러야 함
                arr[i - 1] = 1;
                arr[i] = (1 - arr[i]);
                arr[i + 1] = (1 - arr[i + 1]);
            }
            // System.out.println("i : " + i + ", arr : " + Arrays.toString(arr));
        }
        // i = N - 1
        if (N >= 2 && arr[N - 1 - 1] == 0) {
            cnt++;
            // arr[N - 1]을 눌러야 함
            arr[N - 1 - 1] = 0;
            arr[N - 1] = 1 - arr[N - 1];
            // System.out.println("i : " + (N - 1) + ", arr : " + Arrays.toString(arr));
        }

        System.out.print(arr[N - 1] == 1 ? cnt : -1);
    }
}