import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cpX = new int[N];
        int[] cpY = new int[N];
        for (int i = 0; i < N; i++) {
            cpX[i] = sc.nextInt();
            cpY[i] = sc.nextInt();
        }

        int minDist = Integer.MAX_VALUE;
        
        for (int i = 1; i < N - 1; i++) {
            int x = cpX[0], y = cpY[0], sumDist = 0;
            int nextX, nextY;
            for (int j = 1; j < N; j++) {
                if (j == i) continue; // i번째 점을 생략
                nextX = cpX[j]; nextY = cpY[j];
                // 거리 구하기
                int dist = Math.abs(nextX - x) + Math.abs(nextY - y);
                sumDist += dist;
                x = nextX; y = nextY;
            }
            // System.out.println("sumDist : " + sumDist + ", i : " + i);
            minDist = Math.min(minDist, sumDist);
        }

        System.out.println(minDist);
    }
}