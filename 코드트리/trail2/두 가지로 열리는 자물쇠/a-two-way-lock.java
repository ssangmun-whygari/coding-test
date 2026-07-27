import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        for (int i = 0; i < 3; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            arr2[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (isValid(i, j, k, arr1) || isValid(i, j, k, arr2)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean isValid(int x0, int x1, int x2, int[] arr) {
        return (getDiff(x0, arr[0]) <= 2 && getDiff(x1, arr[1]) <= 2 && getDiff(x2, arr[2]) <= 2);
    }

    public static int getDiff(int x, int y) {
        int small = (x < y) ? x : y;
        int large = (x > y) ? x : y;

        int cand1 = large - small;
        int cand2 = small + N - large;

        return Math.min(cand1, cand2);
    }
}