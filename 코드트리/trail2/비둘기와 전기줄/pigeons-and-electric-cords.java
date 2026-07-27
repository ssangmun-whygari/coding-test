import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[10];
        Arrays.fill(arr, -1);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt() - 1;
            int pos = sc.nextInt();

            if (arr[pigeon] == -1) { // 처음으로 관측
                arr[pigeon] = pos;
            } else if (arr[pigeon] != pos) {
                arr[pigeon] = pos;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}