import java.util.*;

public class Main {
    public static int[] sorted;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        sorted = new int[N];

        mergeSort(arr, 0, N - 1);

        for (int a : sorted) {
            System.out.print(a + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        // System.out.println("low : " + low + ", high : " + high);
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                sorted[k++] = arr[i];
                i++;
            } else {
                sorted[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            sorted[k++] = arr[i];
            i++;
        }
        while (j <= high) {
            sorted[k++] = arr[j];
            j++;
        }

        for (i = low; i <= high; i++) {
            arr[i] = sorted[i];
        }
    }
}