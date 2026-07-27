import java.util.*;

public class Main {
    public static int[] arr1;
    public static int[] arr2;
    public static int[] arr3;
    public static int N;
    public static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = sc.nextInt();
        arr1 = new int[N];
        arr2 = new int[N];
        arr3 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arr3[i] = sc.nextInt();
        }

        int temp1, temp2, temp3 = 0;
        for (int t = 0; t < T; t++) {
            temp1 = arr1[N - 1];
            temp2 = arr2[N - 1];
            temp3 = arr3[N - 1];

            for (int i = N - 1; i >= 1; i--) {
                arr1[i] = arr1[i - 1];
            }
            arr1[0] = temp3;

            for (int i = N - 1; i >= 1; i--) {
                arr2[i] = arr2[i - 1];
            }
            arr2[0] = temp1;

            for (int i = N - 1; i >= 1; i--) {
                arr3[i] = arr3[i - 1];
            }
            arr3[0] = temp2;
        }

        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}