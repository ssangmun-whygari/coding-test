import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 평륜 구하기
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                double avg = (double) sum / (j - i + 1);

                // 평균이 구간안에 있는지 검사
                boolean found = false;
                for (int k = i; k <= j; k++) {
                    if ((double) arr[k] == avg) found = true;
                }
                if (found) {
                    // System.out.println("i : " + i + ",j : " + j + ",avg : " + avg);
                    cnt++;
                } 
            }
        }
        System.out.println(cnt);
    }
}