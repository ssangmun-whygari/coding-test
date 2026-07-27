import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = Arrays.stream(arr).sum();

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    int partSum = arr[i] + arr[j] + arr[k];
                    int partSum2 = sum - partSum;
                    minDiff = Math.min(minDiff, Math.abs(partSum - partSum2));
                }
            }
        }
        System.out.println(minDiff);
    }
}