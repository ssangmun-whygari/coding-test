import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int A = arr[0], B = arr[1];
        int sum = arr[arr.length - 1];
        int C = sum - A - B;

        System.out.print(A + " " + B + " " + C);
    }
}