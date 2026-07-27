import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int a, b;

        int[] rooms = new int[N + 1]; // 1 ~ N

        for (int i = 0; i < K; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            
            for (int j = a; j <= b; j++) {
                rooms[j] += 1;
            }
        }

        System.out.println(Arrays.stream(rooms).max().orElse(0));
    }
}