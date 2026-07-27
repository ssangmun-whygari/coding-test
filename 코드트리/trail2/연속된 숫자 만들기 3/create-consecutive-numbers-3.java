import java.util.*;
public class Main {
    public static void main(String[] args) {
        

        // a a+1 a+2

        // a a+2 b or a b b+2

        // 1 3 7


        // 1 3 7 -> 3 4 7 -> 4 5 7 -< 5 6 7

        // 1 4 12

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        int cnt = 0;

        while (true) {
            if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
                break;
            }

            if (arr[1] - arr[0] < arr[2] - arr[1]) {
                // 1과 2 사이에 끼워넣는다.
                arr[0] = arr[1];
                arr[1] = arr[0] + 1;
            } else if (arr[1] - arr[0] > arr[2] - arr[1]) {
                // 0과 1 사이에 끼워넣는다.
                arr[2] = arr[1];
                arr[1] = arr[0] + 1;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}