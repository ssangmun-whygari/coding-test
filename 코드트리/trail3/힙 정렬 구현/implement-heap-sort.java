import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println("arr : " + Arrays.toString(arr));
        
        // max heap 만들기
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, n, i);
        }
        // System.out.println("arr : " + Arrays.toString(arr));

        for (int i = n; i > 1; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapify(arr, i - 1, 1);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapify(int[] arr, int n, int k) {
        int largest = k;
        int lc = 2 * k;
        int rc = (2 * k) + 1;

        if (lc <= n && arr[lc] > arr[largest])
            largest = lc;
        if (rc <= n && arr[rc] > arr[largest])
            largest = rc;
        if (largest != k) {
            int temp = arr[largest];
            arr[largest] = arr[k];
            arr[k] = temp;
            heapify(arr, n, largest);
        }
    }       
}