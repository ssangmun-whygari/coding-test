import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[1000 + 1]; // 1 ~ 1000
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            intervals[i][0] = start; intervals[i][1] = end;
            for (int j = start; j < end; j++) {
                arr[j] += 1;
            }
        }

        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                for (int k = intervals[j][0]; k < intervals[j][1]; k++) {
                    arr[k] -= 1;
                }

                // 가동 시간을 셈
                int workingTime = 0;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] > 0) workingTime++;
                }
                // 최대 시간 갱신
                maxTime = Math.max(maxTime, workingTime);

                // 개수를 다 세면 원래대로 복원
                for (int k = intervals[j][0]; k < intervals[j][1]; k++) {
                    arr[k] += 1;
                }
            }
        }

        System.out.println(maxTime);
    }
}