import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int minX = Integer.MAX_VALUE;
            int maxX = 0;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                minX = Math.min(minX, x1[j]);
                maxX = Math.max(maxX, x2[j]);
            }
            int length = maxX - minX;
            minLength = Math.min(minLength, length);
        }

        System.out.println(minLength);
    }
}