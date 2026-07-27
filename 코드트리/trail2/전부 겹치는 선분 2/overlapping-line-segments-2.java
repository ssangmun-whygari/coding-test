import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        boolean answer = false;
        // 제거할 선분을 선택
        for (int i = 0; i < N; i++) {
            int maxX = 0;
            int minY = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                maxX = Math.max(maxX, x[j]);
                minY = Math.min(minY, y[j]);
            }

            if (maxX <= minY) {
                answer = true;
            }
        }

        if (answer) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}