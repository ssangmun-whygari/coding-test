import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sorted = new int[N];
        System.arraycopy(arr, 0, sorted, 0, N);
        Arrays.sort(sorted);

        // 최소값 구하기
        int minVal = sorted[0];
        // System.out.println("minVal : " + minVal);

        // 1. 다 같음 (두번째로 작은 수가 없음)
        boolean isAllSame = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] != minVal) {
                isAllSame = false;
                break;
            }
        }
        // System.out.println("isAllSame : " + isAllSame);

        if (isAllSame) {
            System.out.println(-1);
            System.exit(0);
        }

        // 2. 두번째로 작은 수가 여러개임

        // 두번째로 작은 수 구하기
        int secondMin = 101;
        int secondMinIdx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > minVal && arr[i] < secondMin) {
                secondMin = arr[i];
                secondMinIdx = i;
            }
        }

        boolean duplicated = false;
        for (int i = 0; i < N; i++) {
            if (secondMinIdx != i && arr[i] == secondMin) {
                duplicated = true;
                break;
            }
        }

        // System.out.println("duplicated : " + duplicated);
        // System.out.println("secondMinIdx : " + secondMinIdx);
        if (duplicated) {
            System.out.println(-1);
        } else {
            System.out.println(secondMinIdx + 1);
        }
    }
}