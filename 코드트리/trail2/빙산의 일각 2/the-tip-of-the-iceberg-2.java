import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int maxCnt = 0;
        for (int i = 0; i < 1000; i++) { // 해수면의 높이
            int cnt = 0;
            for (int j = 0; j < N; j++) { // 각 칸
                if (j == 0) {
                    if (arr[j] > i) cnt++;
                } else {
                    // arr[j - 1]이 물에 잠겨있고 arr[j]가 물에 뜬 경우
                    if (arr[j - 1] <= i && arr[j] > i) cnt++;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
    }
}