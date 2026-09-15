import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n]; // 각 장소마다 에너지 1을 채우는 데 필요한 비용
        int[] dist = new int[n - 1]; // 장소와 장소 사이의 거리

        for (int i = 0; i < n - 1; i++) {
            dist[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        
        int[] L = new int[n]; // i번째까지의 장소 중에서 제일 충전비용이 작은 장소의 비용을 저장
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }
            L[i] = minCost;
        }

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            // dist[i]
            sum += ((long) dist[i] * L[i]);
        }
        System.out.print(sum);
    }
}