import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int endOfArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        endOfArr = N;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            boolean exist = bomb();
            if (!exist) break;
        }

        System.out.println(endOfArr);
        for (int i = 0; i < endOfArr; i++) {
            System.out.println(arr[i]);
        }
    }

    public static boolean bomb() {
        int[] tempArr = new int[N];
        int endOfTempArr = 0;
        boolean exist = false;

        int cur = arr[0];
        int curNum = (cur > 0) ? 1 : 0;
        for (int i = 1; i < endOfArr; i++) {
            if (arr[i] == cur) {
                curNum++;
            } else {
                if (curNum < M) {
                    while (curNum-- > 0) {
                        tempArr[endOfTempArr++] = cur;
                    }
                } else {
                    exist = true;
                }
                cur = arr[i];
                curNum = 1;
            }
        }

        if (curNum < M) {
            while (curNum-- > 0) {
                tempArr[endOfTempArr++] = cur;
            }
        } else {
            exist = true;
        }

        // System.out.println("tempArr : " + Arrays.toString(tempArr));
        // System.out.println("endOfTempArr : " + endOfTempArr);
        // System.out.println("exist : " + exist);

        arr = tempArr;
        endOfArr = endOfTempArr;
        return exist;
    }
}