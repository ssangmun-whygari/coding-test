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
        int maxCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] * arr[i - 1] > 0) { // 부호가 같을때
                cnt++;
            } else {
                cnt = 1;
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.println(maxCnt);
    }
}