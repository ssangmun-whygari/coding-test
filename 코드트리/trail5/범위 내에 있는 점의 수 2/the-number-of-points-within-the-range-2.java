import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] points = new int[1_000_000 + 1];
        for (int i = 0; i < N; i++) {
            points[sc.nextInt()] = 1;
        }

        int[] pfSum = new int[1_000_000 + 1];
        for (int i = 1; i <= 1_000_000; i++) {
            pfSum[i] = pfSum[i - 1] + points[i];
        }

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            sb.append(pfSum[e] - pfSum[s] + points[s] + "\n");
        }
        System.out.print(sb.toString());

    }
}