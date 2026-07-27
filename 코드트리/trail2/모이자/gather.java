import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // a[i]의 좌표 : i + 1
            // i번째 집을 모임 장소로 정했을 때
            // 각각의 집에 살고 있는 사람들의 이동거리를 구하려면
            int dist = 0;
            for (int j = 0; j < n; j++) {
                dist += Math.abs(i - j) * a[j];
            }
            answer = Math.min(answer, dist);
        }

        System.out.println(answer);
    }
}