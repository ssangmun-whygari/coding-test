import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int i = 0;
        int j = n - 1;
        int sum = arr[0] + arr[n - 1];
        int minAbs = Math.abs(sum);

        while (i < j) {
            sum = arr[i] + arr[j];
            if (Math.abs(sum) < minAbs) {
                minAbs = Math.abs(sum);
            }

            if (sum >= 0) {
                j--;
            } else {
                i++;
            }
        }

        System.out.print(minAbs);
    }

    public static boolean isSignSame(int a, int b) {
        // 0은 양수로 취급함
        int signA = (a >= 0) ? 1 : -1;
        int signB = (b >= 0) ? 1 : -1;

        return (signA * signB == 1) ? true : false;
    }
}