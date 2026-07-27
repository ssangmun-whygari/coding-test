import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // arr[i] : 0 ~ n - 1번 방에 할당량
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 0번 방에서 시작 : 0 -> 0, 0 -> 1, ... 0 -> n - 1
            // 1번 방에서 시작 : 
            // 1 -> 1, (1번 방에 할당된 사람 수 * 거리) = (a * 0)
            // 1 -> 2, (2번 방에 할당된 사람 수 * 거리) = (b * 1)
            // 1 -> 3, 
            // ... 
            // 1 -> n - 1 -> 0

            // i번 방에서 시작
            int sum = 0;
            for (int offset = 0; offset < n; offset++) {
                sum += (arr[(i + offset) % n] * offset);
            }
            // System.out.println("sum : " + sum);
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }
}