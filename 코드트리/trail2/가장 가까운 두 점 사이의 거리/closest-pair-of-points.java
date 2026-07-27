import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] posX = new int[N];
        int[] posY = new int[N];
        for (int i = 0; i < N; i++) {
            posX[i] = sc.nextInt();
            posY[i] = sc.nextInt();
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dist = (int) Math.pow(posX[i] - posX[j], 2) + (int) Math.pow(posY[i] - posY[j], 2);
                minDist = Math.min(minDist, dist);
            }
        }
        System.out.println(minDist);
    }
}