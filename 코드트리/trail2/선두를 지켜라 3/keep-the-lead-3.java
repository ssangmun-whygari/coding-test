import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] posA = new int[1000 * 1000 + 1];
        int[] posB = new int[1000 * 1000 + 1];


        // 1로 2시간동안 이동
        // 2로 1시간동안 이동

        int temp = 1;
        for (int i = 0; i < N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for (int j = temp; j < temp + t; j++) {
                posA[j] = posA[j - 1] + v;
            }
            temp += t;
        }

        temp = 1;
        for (int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for (int j = temp; j < temp + t; j++) {
                posB[j] = posB[j - 1] + v;
            }
            temp += t;
        }

        int[] sundu = new int[1000 * 1000 + 1];

        for (int i = 0; i < temp; i++) {
            if (posA[i] > posB[i]) {
                sundu[i] = 1;
            } else if (posA[i] < posB[i]) {
                sundu[i] = 2;
            } else {
                sundu[i] = 0;
            }
        }

        int changeNum = 0;
        for (int i = 1; i < temp; i++) {
            if (sundu[i] != sundu[i - 1]) {
                changeNum++;
            }
        }

        System.out.println(changeNum);
    }
}