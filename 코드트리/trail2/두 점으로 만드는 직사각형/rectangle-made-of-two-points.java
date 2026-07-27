import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] rect1 = new int[4];
        int[] rect2 = new int[4];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            rect1[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            rect2[i] = sc.nextInt();
        }

        int minX = Math.min(rect1[0], rect2[0]);
        int maxX = Math.max(rect1[2], rect2[2]);
        int minY = Math.min(rect1[1], rect2[1]);
        int maxY = Math.max(rect1[3], rect2[3]);

        System.out.println( (maxX - minX) * (maxY - minY) );
    }
}