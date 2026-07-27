import java.util.*;
public class Main {
    public static int OFFSET = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int[] rooms = new int[200];

        for (int i = 0; i < n; i++) {
            // [x1[i] + offset, x2[i] + offset)
            for (int j = x1[i] + OFFSET; j < x2[i] + OFFSET; j++) {
                rooms[j] += 1;
            }
        }

        System.out.println(Arrays.stream(rooms).max().orElse(0));
    }
}