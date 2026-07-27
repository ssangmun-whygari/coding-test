import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[2*N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        // System.out.println("sorted : " + Arrays.toString(arr));
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int diff = arr[i + N] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }
        System.out.println(minDiff);
    }
}