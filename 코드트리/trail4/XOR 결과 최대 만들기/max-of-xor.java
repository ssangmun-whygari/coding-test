import java.util.*;

public class Main {
    public static int[] arr;
    public static int M;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        recur(0, -1, 0);

        System.out.println(ans);
    }

    public static void recur(int num, int selected, int xorResult) {
        if (num == M) {
            ans = Math.max(ans, xorResult);
            return;
        }

        for (int i = selected + 1; i < arr.length; i++) {
            if (selected == -1) { // 지금이 처음으로 선택하는 경우
                recur(num + 1, i, arr[i]);
            } else {
                recur(num + 1, i, xorResult ^ arr[i]);
            }
        }
    }
}