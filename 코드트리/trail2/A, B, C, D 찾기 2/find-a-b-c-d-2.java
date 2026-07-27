import java.util.*;

public class Main {
    public static int CASE_NUM = 15;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[CASE_NUM];
        for (int i = 0; i < CASE_NUM; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 1; i <= 40; i++) {
            for (int j = i; j <= 40; j++) {
                for (int k = j; k <= 40; k++) {
                    for (int l = k; l <= 40; l++) {
                        int[] arr2 = new int[CASE_NUM];
                        arr2[0] = i; arr2[1] = j; arr2[2] = k; arr2[3] = l;
                        arr2[4] = i + j; arr2[5] = i + k; arr2[6] = i + l; arr2[7] = j + k;
                        arr2[8] = j + l; arr2[9] = k + l;
                        arr2[10] = i + j + k; arr2[11] = i + j + l; arr2[12] = i + k + l;
                        arr2[13] = j + k + l; arr2[14] = i + j + k + l;
                        Arrays.sort(arr2);
                        if (isEqual(arr, arr2)) {
                            System.out.println(i + " " + j + " " + k + " " + l);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        boolean result = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}