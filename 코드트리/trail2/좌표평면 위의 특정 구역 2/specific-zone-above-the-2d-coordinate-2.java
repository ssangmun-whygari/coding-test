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

        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int lx = Integer.MAX_VALUE, ly = Integer.MAX_VALUE;
            int ux = 0, uy = 0;
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                lx = Math.min(lx, posX[j]);
                ly = Math.min(ly, posY[j]);
                ux = Math.max(ux, posX[j]);
                uy = Math.max(uy, posY[j]);
            }
            int area = (ux - lx) * (uy - ly);
            minArea = Math.min(minArea, area);
        }
        System.out.println(minArea);
    }
}