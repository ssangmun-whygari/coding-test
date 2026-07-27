import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x1 = new int[N];
        int[] x2 = new int[N];
        for (int i = 0; i < N; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean intersect = false;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                // i번째 선분과 j번째 선분이 겹치는 가?
                // x1[i], x2[i], x1[i], x2[j]
                if ((x1[i] <= x1[j] && x2[j] <= x2[i]) || (x1[j] <= x1[i] && x2[i] <= x2[j])) {
                    intersect = true;
                    break;
                }
            }
            if (!intersect) cnt++;
        }

        System.out.println(cnt);
    }
}