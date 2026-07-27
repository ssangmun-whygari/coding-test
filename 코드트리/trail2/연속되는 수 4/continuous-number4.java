import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0 ; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 1;
        int maxCnt = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1]) {
                cnt = 1;
            } else {
                cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }
}